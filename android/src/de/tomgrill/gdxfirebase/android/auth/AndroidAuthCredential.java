package de.tomgrill.gdxfirebase.android.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthCredential;

public class AndroidAuthCredential implements AuthCredential {
    private com.google.firebase.auth.AuthCredential authCredential;

    AndroidAuthCredential(com.google.firebase.auth.AuthCredential authCredential) {
        this.authCredential = authCredential;
    }

    @Override
    public String getProvider() {
        return authCredential.getProvider();
    }

    com.google.firebase.auth.AuthCredential getFirebaseAuthCredential() {
        return authCredential;
    }
}
