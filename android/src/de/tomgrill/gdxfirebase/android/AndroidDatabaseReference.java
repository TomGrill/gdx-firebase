package de.tomgrill.gdxfirebase.android;


import de.tomgrill.gdxfirebase.core.DatabaseReference;

public class AndroidDatabaseReference implements DatabaseReference {

    private com.google.firebase.database.DatabaseReference databaseReference;

    public AndroidDatabaseReference(com.google.firebase.database.DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    @Override
    public DatabaseReference child(String s) {
        return new AndroidDatabaseReference(databaseReference.child(s));
    }

    @Override
    public DatabaseReference push() {
        return new AndroidDatabaseReference(databaseReference.push());
    }

    @Override
    public String getKey() {
        return databaseReference.getKey();
    }

    @Override
    public void setValue(Object o) {
        databaseReference.setValue(o);
    }
}
