package de.tomgrill.gdxfirebase.desktop.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthProvider;

public class DesktopGoogleAuthProvider implements AuthProvider {


    private DesktopGoogleAuthCredential credential;

    DesktopGoogleAuthProvider(String accessToken) {
        credential = new DesktopGoogleAuthCredential(this, accessToken);
    }

    @Override
    public AuthCredential getCredentials() {
        return credential;
    }

    @Override
    public String getProviderId() {
        return "google.com";
    }
}
