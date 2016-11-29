package de.tomgrill.gdxfirebase.android.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthResult;

@Deprecated
public class AndroidAuthResult implements AuthResult {

    private com.google.firebase.auth.AuthResult authResult;

    public AndroidAuthResult(com.google.firebase.auth.AuthResult authResult) {
        this.authResult = authResult;
    }

//    @Override
//    public FirebaseUser getUser() {
//        return null;
//    }
}
