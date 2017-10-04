package de.tomgrill.gdxfirebase.iosmoe.admob;

import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.admob.FirebaseAdmob;
import de.tomgrill.gdxfirebase.core.admob.Interstitial;

public class IOSMOEFirebaseAdmob implements FirebaseAdmob {

    private FirebaseConfiguration firebaseConfiguration;

    public IOSMOEFirebaseAdmob() {

    }
/*
    FOR SOME REASON, IOS MOE ONLY FINDS DEFAULT CONSTRUCTOR
 */
    public IOSMOEFirebaseAdmob(String name, FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
    }

    public IOSMOEFirebaseAdmob(FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
    }

    @Override
    public Interstitial interstitial(String addId) {
        return new IOSMOEInterstitial(addId);
    }
}
