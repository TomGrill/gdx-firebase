package de.tomgrill.gdxfirebase.core;

public interface DatabaseError {
//    public static com.google.firebase.database.DatabaseError fromStatus(java.lang.String status) { /* compiled code */ }
//
//    public static com.google.firebase.database.DatabaseError fromStatus(java.lang.String status, java.lang.String reason) { /* compiled code */ }
//
//    public static com.google.firebase.database.DatabaseError fromCode(int code) { /* compiled code */ }
//
//    public static com.google.firebase.database.DatabaseError fromStatus(java.lang.String status, java.lang.String reason, java.lang.String details) { /* compiled code */ }
//
//    public static com.google.firebase.database.DatabaseError fromException(java.lang.Throwable e) { /* compiled code */ }
//
//    private DatabaseError(int code, java.lang.String message) { /* compiled code */ }
//
//    private DatabaseError(int code, java.lang.String message, java.lang.String details) { /* compiled code */ }
//
    int getCode();

    String getMessage();

    String getDetails();

    String toString();
//
//    public com.google.firebase.database.DatabaseException toException() { /* compiled code */ }
}
