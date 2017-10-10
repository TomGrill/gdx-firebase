package de.tomgrill.gdxfirebase.iosmoe.auth;

import com.google.firebaseauth.FIRAuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthCredential;

public interface IOSMOEAuthCredential extends AuthCredential {

    FIRAuthCredential getFIRAuthCredential();
}
