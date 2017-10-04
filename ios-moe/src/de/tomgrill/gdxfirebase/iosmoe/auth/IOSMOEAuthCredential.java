package de.tomgrill.gdxfirebase.iosmoe.auth;

import de.tomgrill.gdxfirebase.bindings.firebaseauth.FIRAuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthCredential;

public interface IOSMOEAuthCredential extends AuthCredential {

    FIRAuthCredential getFIRAuthCredential();
}
