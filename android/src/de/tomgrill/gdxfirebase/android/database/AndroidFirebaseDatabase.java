package de.tomgrill.gdxfirebase.android.database;


import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;

public class AndroidFirebaseDatabase implements FirebaseDatabase {

    public AndroidFirebaseDatabase(FirebaseConfiguration firebaseConfiguration) {
        // Android configuration is made with json file
    }


    @Override
    public DatabaseReference getReference() {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance().getReference();
        return new AndroidDatabaseReference(databaseReference, this);
    }

    @Override
    public DatabaseReference getReference(String s) {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance().getReference(s);
        return new AndroidDatabaseReference(databaseReference, this);
    }
}
