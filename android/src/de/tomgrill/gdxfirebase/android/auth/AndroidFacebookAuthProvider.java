package de.tomgrill.gdxfirebase.android.auth;

import com.google.firebase.auth.FacebookAuthProvider;
import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthProvider;

class AndroidFacebookAuthProvider implements AuthProvider {

    private AndroidFacebookAuthCredential credential;

    AndroidFacebookAuthProvider(String accessToken) {
        com.google.firebase.auth.AuthCredential credential = FacebookAuthProvider.getCredential(accessToken);
        this.credential = new AndroidFacebookAuthCredential(credential);
    }

    @Override
    public AuthCredential getCredentials() {
        return credential;
    }

    @Override
    public String getProviderId() {
        return credential.getProvider();
    }
}
