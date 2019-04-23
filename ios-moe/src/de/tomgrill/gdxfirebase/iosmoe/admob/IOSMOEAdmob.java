package de.tomgrill.gdxfirebase.iosmoe.admob;

import android.os.Bundle;
import apple.adsupport.ASIdentifierManager;
import apple.foundation.NSError;
import apple.foundation.NSMutableArray;
import apple.foundation.NSURL;
import apple.uikit.UIViewController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.iosmoe.IOSApplication;
import com.google.firebasecore.FIRApp;
import com.google.googlemobileads.GADMobileAds;
import de.tomgrill.gdxfirebase.bindings.pac.PACConsentForm;
import de.tomgrill.gdxfirebase.bindings.pac.PACConsentInformation;
import de.tomgrill.gdxfirebase.bindings.pac.enums.PACConsentStatus;
import de.tomgrill.gdxfirebase.bindings.pac.enums.PACDebugGeography;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.FirebaseConfigurationHolder;
import de.tomgrill.gdxfirebase.core.admob.*;
import de.tomgrill.gdxfirebase.iosmoe.ConfigureOverwatch;

public class IOSMOEAdmob implements Admob, FirebaseConfigurationHolder {

    private FirebaseConfiguration firebaseConfiguration;
    private boolean isTestDevice;
    private UIViewController controller;

    private String deviceId;

    private de.tomgrill.gdxfirebase.core.admob.ConsentStatus currentConsentStatus = ConsentStatus.UNKNOWN;

    public IOSMOEAdmob() {
        if (!ConfigureOverwatch.isConfigured) {
            FIRApp.configure();
            ConfigureOverwatch.isConfigured = true;
        }

        deviceId = ASIdentifierManager.alloc().advertisingIdentifier().UUIDString();
    }

    private void updateStatus(final long status) {

        if(status == PACConsentStatus.NonPersonalized) {
            currentConsentStatus = ConsentStatus.NON_PERSONALIZED;
            return;
        }
        if(status == PACConsentStatus.Personalized) {
            currentConsentStatus = ConsentStatus.PERSONALIZED;
            return;
        }
        if(status == PACConsentStatus.Unknown) {
            currentConsentStatus = ConsentStatus.UNKNOWN;
            return;
        }
        // fallback
        currentConsentStatus = ConsentStatus.UNKNOWN;
    }

    @Override
    public VideoRewardAd getVideoRewardAd() {

        if (isTestDevice) {
            //String deviceId = getDeviceId();
            Gdx.app.debug("gdx-firebase", "Load Admob AdRequest with test device." );

            return new IOSMOEVideoRewardAd(firebaseConfiguration, currentConsentStatus != de.tomgrill.gdxfirebase.core.admob.ConsentStatus.PERSONALIZED);
        } else {
            Gdx.app.debug("gdx-firebase", "Load Admob AdRequest for production)");
            return new IOSMOEVideoRewardAd(firebaseConfiguration, currentConsentStatus != de.tomgrill.gdxfirebase.core.admob.ConsentStatus.PERSONALIZED);
        }
    }

    @Override
    public boolean isTestDevice() {
        return isTestDevice;
    }

    @Override
    public void requestConsentInfoUpdate(final ConsentInfoUpdateListener consentInfoUpdateListener) {

        NSMutableArray nsa = NSMutableArray.alloc().init();
        for (int i = 0; i < firebaseConfiguration.admobPublisherIds.length; i++) {
            nsa.add(firebaseConfiguration.admobPublisherIds[i]);
        }

        PACConsentInformation.sharedInstance().requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler(nsa, new PACConsentInformation.Block_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler() {
            @Override
            public void call_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler(final NSError error) {
                if (error != null) {
                    updateStatus(PACConsentStatus.Unknown);

                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            consentInfoUpdateListener.onFailedToUpdateConsentInfo(error.localizedDescription());
                        }
                    });

                } else {

                    updateStatus(PACConsentInformation.sharedInstance().consentStatus());
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            consentInfoUpdateListener.onConsentInfoUpdated(currentConsentStatus);
                        }
                    });
                }

            }
        });

    }

    @Override
    public boolean isRequestLocationInEeaOrUnknown() {
        return PACConsentInformation.sharedInstance().isRequestLocationInEEAOrUnknown();
    }

    @Override
    public void showGoogleConsentDialog(boolean withAdFree, final ConsentFormListener consentFormListener) {

        final PACConsentForm pacConsentForm = PACConsentForm.alloc().initWithApplicationPrivacyPolicyURL(NSURL.URLWithString(firebaseConfiguration.admobPrivacyURL));
        pacConsentForm.setShouldOfferAdFree(withAdFree);
        pacConsentForm.setShouldOfferNonPersonalizedAds(true);
        pacConsentForm.setShouldOfferPersonalizedAds(true);

        pacConsentForm.loadWithCompletionHandler(new PACConsentForm.Block_loadWithCompletionHandler() {
            @Override
            public void call_loadWithCompletionHandler(final NSError errorLoad) {

                if (errorLoad != null) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            consentFormListener.onConsentFormError(errorLoad.localizedDescription());
                        }
                    });
                } else {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            consentFormListener.onConsentFormLoaded();

                        pacConsentForm.presentFromViewControllerDismissCompletion(controller, new PACConsentForm.Block_presentFromViewControllerDismissCompletion() {
                            @Override
                            public void call_presentFromViewControllerDismissCompletion(final NSError errorShow, final boolean userPrefersAdFree) {

                                if (errorShow != null) {
                                    Gdx.app.postRunnable(new Runnable() {
                                        @Override
                                        public void run() {
                                            consentFormListener.onConsentFormError(errorShow.localizedDescription());
                                        }
                                    });
                                } else {
                                    updateStatus(PACConsentInformation.sharedInstance().consentStatus());
                                    Gdx.app.postRunnable(new Runnable() {
                                        @Override
                                        public void run() {
                                            consentFormListener.onConsentFormClosed(currentConsentStatus, userPrefersAdFree);
                                        }
                                    });
                                }
                            }
                        });
                        }
                    });
                }

            }
        });
    }

    @Override
    public boolean isConsentGiven() {
        return currentConsentStatus != ConsentStatus.UNKNOWN;
    }

    @Override
    public ConsentStatus getConsentStatus() {
        return currentConsentStatus;
    }

    @Override
    public void setFirebaseConfiguration(FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
        isTestDevice = firebaseConfiguration.admobUseTestDevice;

        GADMobileAds.configureWithApplicationID(firebaseConfiguration.admobAppId);


        if (isTestDevice) {
            PACConsentInformation.sharedInstance().setDebugGeography(PACDebugGeography.EEA);
        }

        NSMutableArray nsa = NSMutableArray.alloc().init();
        for (int i = 0; i < firebaseConfiguration.admobPublisherIds.length; i++) {
            nsa.add(firebaseConfiguration.admobPublisherIds[i]);
        }

        PACConsentInformation.sharedInstance().requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler(nsa, new PACConsentInformation.Block_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler() {
            @Override
            public void call_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler(NSError error) {
                if (error != null) {
                    updateStatus(PACConsentStatus.Unknown);

                } else {
                    updateStatus(PACConsentInformation.sharedInstance().consentStatus());
                }

            }
        });

        controller = ((IOSApplication) Gdx.app).getUIViewController();
    }
}
