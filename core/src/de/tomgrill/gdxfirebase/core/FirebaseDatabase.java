package de.tomgrill.gdxfirebase.core;

public interface FirebaseDatabase {

    DatabaseReference getReference();

    DatabaseReference getReference(String s);
}
