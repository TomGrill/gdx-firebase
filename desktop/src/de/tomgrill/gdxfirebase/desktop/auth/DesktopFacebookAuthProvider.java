package de.tomgrill.gdxfirebase.desktop.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthProvider;

class DesktopFacebookAuthProvider implements AuthProvider {

    private DesktopFacebookAuthCredential credential;

    DesktopFacebookAuthProvider(String accessToken) {
        credential = new DesktopFacebookAuthCredential(this, accessToken);
    }

    @Override
    public AuthCredential getCredentials() {
        return credential;
    }

    @Override
    public String getProviderId() {
        return "facebook.com";
    }
}
