package de.tomgrill.gdxfirebase.core.database;

public interface ValueEventListener {

    void onDataChange(de.tomgrill.gdxfirebase.core.database.DataSnapshot dataSnapshot);

    void onCancelled(de.tomgrill.gdxfirebase.core.database.DatabaseError databaseError);
}
