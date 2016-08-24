package de.tomgrill.gdxfirebase.core;

import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

public class GDXFirebase {

    private static FirebaseDatabase firebaseDatabase;
    private static FirebaseAuth firebaseAuth;

    static void setFirebaseDatabase(FirebaseDatabase firebaseDatabase) {
        GDXFirebase.firebaseDatabase = firebaseDatabase;
    }

    static void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        GDXFirebase.firebaseAuth = firebaseAuth;
    }


    public static synchronized FirebaseDatabase FirebaseDatabase() {
        return GDXFirebase.firebaseDatabase;
    }

    public static synchronized FirebaseAuth FirebaseAuth() {
        return GDXFirebase.firebaseAuth;
    }
}
