package de.tomgrill.gdxfirebase.iosmoe.auth;


import com.google.firebaseauth.FIRAuthCredential;

public class IOSMOEGoogleAuthCredential implements IOSMOEAuthCredential {

    private FIRAuthCredential firAuthCredential;

    IOSMOEGoogleAuthCredential(FIRAuthCredential firAuthCredential) {
        this.firAuthCredential = firAuthCredential;
    }


    @Override
    public FIRAuthCredential getFIRAuthCredential() {
        return firAuthCredential;
    }

    @Override
    public String getProvider() {
        return "google.com";
    }
}
