package de.tomgrill.gdxfirebase.android.auth;

import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthProvider;

class AndroidGoogleAuthProvider implements AuthProvider {

    private AndroidGoogleAuthCredential credential;

    AndroidGoogleAuthProvider(String accessToken) {
        com.google.firebase.auth.AuthCredential credential = GoogleAuthProvider.getCredential(accessToken, null);
        this.credential = new AndroidGoogleAuthCredential(credential);
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
