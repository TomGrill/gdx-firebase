package de.tomgrill.gdxfirebase.core.admob;

import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;

public interface Admob {

    VideoRewardAd getVideoRewardAd();

    boolean isTestDevice();

    void requestConsentInfoUpdate(ConsentInfoUpdateListener consentInfoUpdateListener);

    boolean isRequestLocationInEeaOrUnknown();

    void showGoogleConsentDialog(boolean withAdFree, ConsentFormListener consentFormListener);

    boolean isConsentGiven();

    ConsentStatus getConsentStatus();


}
