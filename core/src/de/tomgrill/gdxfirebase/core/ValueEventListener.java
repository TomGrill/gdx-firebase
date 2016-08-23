package de.tomgrill.gdxfirebase.core;

public interface ValueEventListener {

    void onDataChange(DataSnapshot dataSnapshot);

    void onCancelled(DatabaseError databaseError);
}
