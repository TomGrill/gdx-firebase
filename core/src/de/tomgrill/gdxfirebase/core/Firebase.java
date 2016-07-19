package de.tomgrill.gdxfirebase.core;

public class Firebase {

    private static FirebaseDatabase firebaseDatabase;

    public static void setFirebaseDatabase(FirebaseDatabase firebaseDatabase){
        Firebase.firebaseDatabase = firebaseDatabase;
    }

    public static FirebaseDatabase getDatabaseInstance() {
        return firebaseDatabase;
    }
}
