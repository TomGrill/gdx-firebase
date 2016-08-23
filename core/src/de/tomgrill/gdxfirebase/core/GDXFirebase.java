package de.tomgrill.gdxfirebase.core;

public class GDXFirebase {

    private static de.tomgrill.gdxfirebase.core.database.FirebaseDatabase firebaseDatabase;

    static void setFirebaseDatabase(de.tomgrill.gdxfirebase.core.database.FirebaseDatabase firebaseDatabase){
        GDXFirebase.firebaseDatabase = firebaseDatabase;
    }

    public static de.tomgrill.gdxfirebase.core.database.FirebaseDatabase FirebaseDatabase() {
        return firebaseDatabase;
    }
}
