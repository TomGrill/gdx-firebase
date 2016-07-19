package de.tomgrill.gdxfirebase.core;

public interface DatabaseReference {
    DatabaseReference child(String s);

    DatabaseReference push();

    String getKey();

    void setValue(Object o);
}
