package de.tomgrill.gdxfirebase.core.database;

import java.util.Map;

public interface DatabaseReference extends Query {
    DatabaseReference child(String s);

    DatabaseReference push();

    void setValue(Object value);

    void setValue(Object value, Object priority);

    void setValue(Object value, CompletionListener listener);

    void setValue(Object value, Object priority, CompletionListener listener);

    void setPriority(Object priority);

    void setPriority(Object priority, CompletionListener listener);

    void updateChildren(Map<String, Object> update);

    void updateChildren(Map<String, Object> update, CompletionListener listener);

    void removeValue();

    void removeValue(CompletionListener listener);

//    onDisconnect()

//    public void runTransaction(com.google.firebase.database.Transaction.Handler handler) { /* compiled code */ }

//    public void runTransaction(com.google.firebase.database.Transaction.Handler handler, boolean fireLocalEvents) { /* compiled code */ }

//    public static void goOffline() { /* compiled code */ }

//    static void goOffline(com.google.firebase.database.core.DatabaseConfig config) { /* compiled code */ }

//    public static void goOnline() { /* compiled code */ }

//    static void goOnline(com.google.firebase.database.core.DatabaseConfig config) { /* compiled code */ }

    FirebaseDatabase getDatabase();

    String toString();

    DatabaseReference getParent();

    DatabaseReference getRoot();

    String getKey();

    boolean equals(java.lang.Object other);

    int hashCode();

//    void setHijackHash(boolean hijackHash);

    public static interface CompletionListener {
        void onComplete(de.tomgrill.gdxfirebase.core.database.DatabaseError databaseError, DatabaseReference databaseReference);
    }

}
