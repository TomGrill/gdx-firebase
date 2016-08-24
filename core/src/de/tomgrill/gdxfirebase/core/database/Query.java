package de.tomgrill.gdxfirebase.core.database;

public interface Query {

    ValueEventListener addValueEventListener(ValueEventListener listener);

    de.tomgrill.gdxfirebase.core.database.ChildEventListener addChildEventListener(de.tomgrill.gdxfirebase.core.database.ChildEventListener listener);

    void addListenerForSingleValueEvent(final ValueEventListener listener);

    void removeEventListener(ValueEventListener listener);

    void removeEventListener(de.tomgrill.gdxfirebase.core.database.ChildEventListener listener);

    void keepSynced(final boolean keepSynced);

    Query startAt(String value);

    Query startAt(double value);

    Query startAt(boolean value);

    Query startAt(String value, String key);

    Query startAt(double value, String key);

    Query startAt(boolean value, String key);

    Query endAt(String value);

    Query endAt(double value);

    Query endAt(boolean value);

    Query endAt(String value, String key);

    Query endAt(double value, String key);

    Query endAt(boolean value, String key);

    Query equalTo(String value);

    Query equalTo(double value);

    Query equalTo(boolean value);

    Query equalTo(String value, String key);

    Query equalTo(double value, String key);

    Query equalTo(boolean value, String key);

    Query limitToFirst(int limit);

    Query limitToLast(int limit);

    Query orderByChild(String path);

    Query orderByPriority();

    Query orderByKey();

    Query orderByValue();

//    DatabaseReference getRef(); TODO

//    Path getPath(); TODO

//    Repo getRepo(); TODO

//    QuerySpec getSpec(); TODO
}
