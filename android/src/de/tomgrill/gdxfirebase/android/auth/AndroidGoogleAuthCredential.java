package de.tomgrill.gdxfirebase.android.auth;

import com.google.firebase.auth.AuthCredential;

class AndroidGoogleAuthCredential implements AndroidAuthCredential {

    private AuthCredential authCredential;

    AndroidGoogleAuthCredential(AuthCredential authCredential) {
        this.authCredential = authCredential;
    }

    @Override
    public String getProvider() {
        return authCredential.getProvider();
    }

    @Override
    public AuthCredential getFirebaseAuthCredential() {
        return authCredential;
    }
}
