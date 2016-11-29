package de.tomgrill.gdxfirebase.android.auth;

import com.google.firebase.auth.AuthCredential;

class AndroidFacebookAuthCredential implements AndroidAuthCredential {

    private com.google.firebase.auth.AuthCredential authCredential;

    AndroidFacebookAuthCredential(com.google.firebase.auth.AuthCredential authCredential) {
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
