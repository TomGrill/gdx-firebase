package de.tomgrill.gdxfirebase.android.admob;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import com.badlogic.gdx.Gdx;
import com.google.ads.consent.*;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.admob.Admob;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class AndroidAdmob implements Admob {

    private final FirebaseConfiguration firebaseConfiguration;
    private final Activity activity;
    private final boolean isTestDevice;
    private ConsentForm consentForm;

    private de.tomgrill.gdxfirebase.core.admob.ConsentStatus currentConsentStatus = de.tomgrill.gdxfirebase.core.admob.ConsentStatus.UNKNOWN;

    public AndroidAdmob(Activity activity, FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
        this.activity = activity;
        isTestDevice = firebaseConfiguration.admobUseTestDevice;
        load();
    }

    private void load() {
        if (isTestDevice) {
            String deviceId = getDeviceId();
            Gdx.app.debug("gdx-firebase", "EU Consent for test device: " + deviceId);
            ConsentInformation.getInstance(activity).addTestDevice(deviceId);
            ConsentInformation.getInstance(activity).
                    setDebugGeography(DebugGeography.DEBUG_GEOGRAPHY_EEA);
        }


        ConsentInformation.getInstance(activity).requestConsentInfoUpdate(firebaseConfiguration.admobPublisherIds, new ConsentInfoUpdateListener() {
            @Override
            public void onConsentInfoUpdated(ConsentStatus consentStatus) {
                updateConsentStatus(consentStatus);
                Gdx.app.debug("gdx-firebase", "onConsentInfoUpdated() returns: " + consentStatus);
            }

            @Override
            public void onFailedToUpdateConsentInfo(String reason) {
                updateConsentStatus(ConsentStatus.UNKNOWN);
                Gdx.app.debug("gdx-firebase", "Could not load Consent Update requestConsentInfoUpdate()");
            }
        });


        MobileAds.initialize(activity, firebaseConfiguration.admobAppId);
    }


    @Override
    public VideoRewardAd getVideoRewardAd() {


        Bundle extras = new Bundle();

        // enable non personalized ads when not allowed
        if (currentConsentStatus != de.tomgrill.gdxfirebase.core.admob.ConsentStatus.PERSONALIZED) {
            extras.putString("npa", "1");
        }


        if (isTestDevice) {
            String deviceId = getDeviceId();
            Gdx.app.debug("gdx-firebase", "Load Admob AdRequest with test device id: " + deviceId);
            return new AndroidVideoRewardAd(activity, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, extras).addTestDevice(deviceId).build());
        } else {
            Gdx.app.debug("gdx-firebase", "Load Admob AdRequest for production)");
            return new AndroidVideoRewardAd(activity, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, extras).build());
        }
    }

    @Override
    public boolean isTestDevice() {
        return isTestDevice;
    }

    private void updateConsentStatus(ConsentStatus androidConsentStatus) {
        currentConsentStatus = convertConsentStatus(androidConsentStatus);
    }

    private de.tomgrill.gdxfirebase.core.admob.ConsentStatus convertConsentStatus(ConsentStatus androidConsentStatus) {
        switch (androidConsentStatus) {
            case PERSONALIZED:
                return de.tomgrill.gdxfirebase.core.admob.ConsentStatus.PERSONALIZED;
            case NON_PERSONALIZED:
                return de.tomgrill.gdxfirebase.core.admob.ConsentStatus.NON_PERSONALIZED;
            default:
                return de.tomgrill.gdxfirebase.core.admob.ConsentStatus.UNKNOWN;
        }
    }

    @Override
    public void requestConsentInfoUpdate(final de.tomgrill.gdxfirebase.core.admob.ConsentInfoUpdateListener coreConsentInfoUpdateListener) {
        ConsentInformation consentInformation = ConsentInformation.getInstance(activity);

        consentInformation.requestConsentInfoUpdate(firebaseConfiguration.admobPublisherIds, new ConsentInfoUpdateListener() {
            @Override
            public void onConsentInfoUpdated(final ConsentStatus consentStatus) {

                updateConsentStatus(consentStatus);

                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        coreConsentInfoUpdateListener.onConsentInfoUpdated(currentConsentStatus);
                    }
                });
            }

            @Override
            public void onFailedToUpdateConsentInfo(final String errorDescription) {

                updateConsentStatus(ConsentStatus.UNKNOWN);

                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        coreConsentInfoUpdateListener.onFailedToUpdateConsentInfo(errorDescription);
                    }
                });
            }
        });
    }

    @Override
    public boolean isRequestLocationInEeaOrUnknown() {
        return ConsentInformation.getInstance(activity).isRequestLocationInEeaOrUnknown();
    }

    @Override
    public void showGoogleConsentDialog(boolean withAdFree, final de.tomgrill.gdxfirebase.core.admob.ConsentFormListener coreConsentFormListener) {
        URL privacyUrl = null;
        try {
            // TODO: Replace with your app's privacy policy URL.
            privacyUrl = new URL(firebaseConfiguration.admobPrivacyURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // Handle error.
        }

        final ConsentForm.Builder formBuilder = new ConsentForm.Builder(activity, privacyUrl);

        formBuilder.withListener(new ConsentFormListener() {
            @Override
            public void onConsentFormLoaded() {
                consentForm.show();
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        coreConsentFormListener.onConsentFormLoaded();
                    }
                });
            }

            @Override
            public void onConsentFormOpened() {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        coreConsentFormListener.onConsentFormOpened();
                    }
                });
            }

            @Override
            public void onConsentFormClosed(final ConsentStatus consentStatus, final Boolean userPrefersAdFree) {
                updateConsentStatus(consentStatus);
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        coreConsentFormListener.onConsentFormClosed(convertConsentStatus(consentStatus), userPrefersAdFree);
                    }
                });
            }

            @Override
            public void onConsentFormError(final String errorDescription) {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        coreConsentFormListener.onConsentFormError(errorDescription);
                    }
                });
            }
        });
        formBuilder.withPersonalizedAdsOption();
        formBuilder.withNonPersonalizedAdsOption();

        if (withAdFree)
            formBuilder.withAdFreeOption();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                consentForm = formBuilder.build();
                consentForm.load();
            }
        });

    }

    @Override
    public boolean isConsentGiven() {
        return currentConsentStatus != de.tomgrill.gdxfirebase.core.admob.ConsentStatus.UNKNOWN;
    }


    @Override
    public de.tomgrill.gdxfirebase.core.admob.ConsentStatus getConsentStatus() {
        return currentConsentStatus;
    }

    private String getDeviceId() {
        String android_id = Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
        return md5(android_id).toUpperCase(Locale.ENGLISH);
    }

    private String md5(final String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
