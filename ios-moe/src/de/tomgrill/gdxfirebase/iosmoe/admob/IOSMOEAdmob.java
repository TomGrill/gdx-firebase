package de.tomgrill.gdxfirebase.iosmoe.admob;

import com.badlogic.gdx.Gdx;
import com.google.firebasecore.FIRApp;
import com.google.googlemobileads.GADMobileAds;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.FirebaseConfigurationHolder;
import de.tomgrill.gdxfirebase.core.admob.*;
import de.tomgrill.gdxfirebase.iosmoe.ConfigureOverwatch;

public class IOSMOEAdmob implements Admob, FirebaseConfigurationHolder {

    private FirebaseConfiguration firebaseConfiguration;
    private boolean isTestDevice;

    public IOSMOEAdmob() {
        if (!ConfigureOverwatch.isConfigured) {
            FIRApp.configure();
            ConfigureOverwatch.isConfigured = true;
        }
    }

    @Override
    public VideoRewardAd getVideoRewardAd() {
        if (isTestDevice) {
            //String deviceId = getDeviceId();
            Gdx.app.debug("gdx-firebase", "Load Admob AdRequest with test device." );
            return new IOSMOEVideoRewardAd(firebaseConfiguration);
        } else {
            Gdx.app.debug("gdx-firebase", "Load Admob AdRequest for production)");
            return new IOSMOEVideoRewardAd(firebaseConfiguration);
        }
    }

    @Override
    public boolean isTestDevice() {
        return isTestDevice;
    }

    @Override
    public void requestConsentInfoUpdate(ConsentInfoUpdateListener consentInfoUpdateListener) {
        consentInfoUpdateListener.onFailedToUpdateConsentInfo("IOSMOE NOT SUPPORTED");
    }

    @Override
    public boolean isRequestLocationInEeaOrUnknown() {
        return false;
    }

    @Override
    public void showGoogleConsentDialog(boolean withAdFree, ConsentFormListener consentFormListener) {
        consentFormListener.onConsentFormError("IOSMOE NOT SUPPORTED");
    }

    @Override
    public boolean isConsentGiven() {
        return false;
    }

    @Override
    public ConsentStatus getConsentStatus() {
        return ConsentStatus.UNKNOWN;
    }

    @Override
    public void setFirebaseConfiguration(FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
        isTestDevice = firebaseConfiguration.admobUseTestDevice;

        GADMobileAds.configureWithApplicationID(firebaseConfiguration.admobAppId);
    }
}
