package de.tomgrill.gdxfirebase.iosmoe.auth;

import com.google.firebaseauth.FIRAuth;
import com.google.firebaseauth.FIRAuthCredential;
import com.google.firebaseauth.FIRGoogleAuthProvider;
import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthProvider;

public class IOEMOEGoogleAuthProvider implements AuthProvider {

    private IOSMOEAuthCredential credential;

    IOEMOEGoogleAuthProvider(String accessToken) {
        FIRAuthCredential authCredential = FIRGoogleAuthProvider.credentialWithIDTokenAccessToken(FIRAuth.auth().currentUser().uid(), accessToken);
        credential = new IOSMOEGoogleAuthCredential(authCredential);
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
