package de.tomgrill.gdxfirebase.core.admob;

public interface ConsentInfoUpdateListener {

    void onConsentInfoUpdated(ConsentStatus consentStatus);

    void onFailedToUpdateConsentInfo(String reason);
}
