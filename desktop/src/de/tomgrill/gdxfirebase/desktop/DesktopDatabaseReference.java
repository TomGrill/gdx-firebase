package de.tomgrill.gdxfirebase.desktop;

import de.tomgrill.gdxfirebase.core.DatabaseReference;

public class DesktopDatabaseReference implements DatabaseReference {
    private com.google.firebase.database.DatabaseReference databaseReference;

    public DesktopDatabaseReference(com.google.firebase.database.DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    @Override
    public DatabaseReference child(String s) {
        return new DesktopDatabaseReference(databaseReference.child(s));
    }

    @Override
    public DatabaseReference push() {
        return new DesktopDatabaseReference(databaseReference.push());
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
