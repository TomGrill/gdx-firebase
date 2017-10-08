package de.tomgrill.gdxfirebase.iosmoe.admob;

import com.badlogic.gdx.Gdx;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADMobileAds;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADRequest;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADRewardBasedVideoAd;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.FirebaseConfigurationHolder;
import de.tomgrill.gdxfirebase.core.admob.Admob;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;

public class IOSMOEAdmob implements Admob, FirebaseConfigurationHolder {

    private FirebaseConfiguration firebaseConfiguration;
    private boolean isTestDevice;

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
    public void setFirebaseConfiguration(FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
        isTestDevice = firebaseConfiguration.admobUseTestDevice;

        GADMobileAds.configureWithApplicationID(firebaseConfiguration.admobAppId);
    }
}
