package de.tomgrill.gdxfirebase.desktop.database;

import com.badlogic.gdx.utils.Array;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import de.tomgrill.gdxfirebase.core.database.ChildEventListener;
import de.tomgrill.gdxfirebase.core.database.Query;
import de.tomgrill.gdxfirebase.core.database.ValueEventListener;

public class DesktopQuery implements Query {

    private com.google.firebase.database.Query query;

    private Array<com.google.firebase.database.ValueEventListener> fbValueEventListenerList;
    private Array<ValueEventListener> valueEventListenerList;

    private Array<com.google.firebase.database.ChildEventListener> fbChildEventListenerList;
    private Array<ChildEventListener> childEventListenerList;

    public DesktopQuery(com.google.firebase.database.Query query) {
        this.query = query;

        fbValueEventListenerList = new Array<>();
        valueEventListenerList = new Array<>();

        fbChildEventListenerList = new Array<>();
        childEventListenerList = new Array<>();

    }

    @Override
    public ValueEventListener addValueEventListener(final ValueEventListener listener) {
        com.google.firebase.database.ValueEventListener fbListener = new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listener.onDataChange(new DesktopDataSnapshot(dataSnapshot));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onCancelled(new DesktopDatabaseError(databaseError));
            }
        };

        query.addValueEventListener(fbListener);

        fbValueEventListenerList.add(fbListener);
        valueEventListenerList.add(listener);

        return listener;
    }

    @Override
    public ChildEventListener addChildEventListener(final ChildEventListener listener) {

        com.google.firebase.database.ChildEventListener fbListener = new com.google.firebase.database.ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                listener.onChildAdded(new DesktopDataSnapshot(dataSnapshot), s);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                listener.onChildChanged(new DesktopDataSnapshot(dataSnapshot), s);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                listener.onChildRemoved(new DesktopDataSnapshot(dataSnapshot));
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                listener.onChildMoved(new DesktopDataSnapshot(dataSnapshot), s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onCancelled(new DesktopDatabaseError(databaseError));
            }
        };

        query.addChildEventListener(fbListener);

        fbChildEventListenerList.add(fbListener);
        childEventListenerList.add(listener);

        return listener;
    }

    @Override
    public void addListenerForSingleValueEvent(final ValueEventListener listener) {

        query.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listener.onDataChange(new DesktopDataSnapshot(dataSnapshot));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onCancelled(new DesktopDatabaseError(databaseError));
            }
        });

    }

    @Override
    public void removeEventListener(ValueEventListener listener) {
        int index = valueEventListenerList.indexOf(listener, true);
        if (index != -1) {

            query.removeEventListener(fbValueEventListenerList.get(index));
            fbValueEventListenerList.removeIndex(index);
            valueEventListenerList.removeIndex(index);
        }
    }

    @Override
    public void removeEventListener(ChildEventListener listener) {
        int index = childEventListenerList.indexOf(listener, true);
        if (index != -1) {

            query.removeEventListener(fbChildEventListenerList.get(index));
            fbChildEventListenerList.removeIndex(index);
            childEventListenerList.removeIndex(index);
        }
    }

    @Override
    public void keepSynced(boolean keepSynced) {
        query.keepSynced(keepSynced);
    }

    @Override
    public Query startAt(String value) {
        return new DesktopQuery(query.startAt(value));
    }

    @Override
    public Query startAt(double value) {
        return new DesktopQuery(query.startAt(value));
    }

    @Override
    public Query startAt(boolean value) {
        return new DesktopQuery(query.startAt(value));
    }

    @Override
    public Query startAt(String value, String key) {
        return new DesktopQuery(query.startAt(value, key));
    }

    @Override
    public Query startAt(double value, String key) {
        return new DesktopQuery(query.startAt(value, key));
    }

    @Override
    public Query startAt(boolean value, String key) {
        return new DesktopQuery(query.startAt(value, key));
    }

    @Override
    public Query endAt(String value) {
        return new DesktopQuery(query.endAt(value));
    }

    @Override
    public Query endAt(double value) {
        return new DesktopQuery(query.endAt(value));
    }

    @Override
    public Query endAt(boolean value) {
        return new DesktopQuery(query.endAt(value));
    }

    @Override
    public Query endAt(String value, String key) {
        return new DesktopQuery(query.endAt(value, key));
    }

    @Override
    public Query endAt(double value, String key) {
        return new DesktopQuery(query.endAt(value, key));
    }

    @Override
    public Query endAt(boolean value, String key) {
        return new DesktopQuery(query.endAt(value, key));
    }

    @Override
    public Query equalTo(String value) {
        return new DesktopQuery(query.equalTo(value));
    }

    @Override
    public Query equalTo(double value) {
        return new DesktopQuery(query.equalTo(value));
    }

    @Override
    public Query equalTo(boolean value) {
        return new DesktopQuery(query.equalTo(value));
    }

    @Override
    public Query equalTo(String value, String key) {
        return new DesktopQuery(query.equalTo(value, key));
    }

    @Override
    public Query equalTo(double value, String key) {
        return new DesktopQuery(query.equalTo(value, key));
    }

    @Override
    public Query equalTo(boolean value, String key) {
        return new DesktopQuery(query.equalTo(value, key));
    }

    @Override
    public Query limitToFirst(int limit) {
        return new DesktopQuery(query.limitToFirst(limit));
    }

    @Override
    public Query limitToLast(int limit) {
        return new DesktopQuery(query.limitToLast(limit));
    }

    @Override
    public Query orderByChild(String path) {
        return new DesktopQuery(query.orderByChild(path));
    }

    @Override
    public Query orderByPriority() {
        return new DesktopQuery(query.orderByPriority());
    }

    @Override
    public Query orderByKey() {
        return new DesktopQuery(query.orderByKey());
    }

    @Override
    public Query orderByValue() {
        return new DesktopQuery(query.orderByValue());
    }

}
