package de.tomgrill.gdxfirebase.core.admob;

public interface ConsentFormListener {

    void onConsentFormLoaded();

    void onConsentFormError(String reason);

    void onConsentFormOpened();

    void onConsentFormClosed(ConsentStatus consentStatus, Boolean userPrefersAdFree);
}
