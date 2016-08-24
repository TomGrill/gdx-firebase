package de.tomgrill.gdxfirebase.core.database;

public interface ChildEventListener {
    void onChildAdded(DataSnapshot dataSnapshot, String string);

    void onChildChanged(DataSnapshot dataSnapshot, String string);

    void onChildRemoved(DataSnapshot dataSnapshot);

    void onChildMoved(DataSnapshot dataSnapshot, String string);

    void onCancelled(DatabaseError databaseError);
}
