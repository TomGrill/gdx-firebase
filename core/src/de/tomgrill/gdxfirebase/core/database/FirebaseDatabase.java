package de.tomgrill.gdxfirebase.core.database;

public interface FirebaseDatabase {

    DatabaseReference getReference();

    DatabaseReference getReference(String s);
}
