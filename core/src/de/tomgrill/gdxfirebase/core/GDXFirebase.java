package de.tomgrill.gdxfirebase.core;

public class GDXFirebase {

    private static FirebaseDatabase firebaseDatabase;

    static void setFirebaseDatabase(FirebaseDatabase firebaseDatabase){
        GDXFirebase.firebaseDatabase = firebaseDatabase;
    }

    public static FirebaseDatabase FirebaseDatabase() {
        return firebaseDatabase;
    }
}
