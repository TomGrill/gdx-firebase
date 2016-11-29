package de.tomgrill.gdxfirebase.desktop.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthProvider;

class DesktopFacebookAuthCredential implements AuthCredential {

    private String accessToken;
    private AuthProvider provider;

    DesktopFacebookAuthCredential(AuthProvider provider, String accessToken) {
        this.accessToken = accessToken;
        this.provider = provider;
    }

    @Override
    public String getProvider() {
        return provider.getProviderId();
    }

    public String getAccessToken() {
        return accessToken;
    }
}
