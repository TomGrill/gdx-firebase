package de.tomgrill.gdxfirebase.android.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthCredential;

public interface AndroidAuthCredential extends AuthCredential {

    @Override
    String getProvider();

    com.google.firebase.auth.AuthCredential getFirebaseAuthCredential();

}
