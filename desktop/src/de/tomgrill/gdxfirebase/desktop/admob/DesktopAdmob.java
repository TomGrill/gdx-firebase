package de.tomgrill.gdxfirebase.desktop.admob;

import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.admob.*;

public class DesktopAdmob implements Admob {
    public DesktopAdmob(String name, FirebaseConfiguration firebaseConfiguration) {
    }

    @Override
    public VideoRewardAd getVideoRewardAd() {
        return new NullVideoRewardAd();
    }

    @Override
    public boolean isTestDevice() {
        return true;
    }

    @Override
    public void requestConsentInfoUpdate(ConsentInfoUpdateListener consentInfoUpdateListener) {
        consentInfoUpdateListener.onFailedToUpdateConsentInfo("DESKTOP HAS NO ADMOB");
    }

    @Override
    public boolean isRequestLocationInEeaOrUnknown() {
        return false;
    }

    @Override
    public void showGoogleConsentDialog(boolean withAdFree, ConsentFormListener consentFormListener) {
        consentFormListener.onConsentFormError("DESKTOP HAS NO ADMOB");
    }

    @Override
    public boolean isConsentGiven() {
        return false;
    }

    @Override
    public ConsentStatus getConsentStatus() {
        return ConsentStatus.UNKNOWN;
    }
}
