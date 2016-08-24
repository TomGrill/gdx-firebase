package de.tomgrill.gdxfirebase.android.database;


import com.google.firebase.database.Logger;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.LogLevel;
import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

public class AndroidFirebaseDatabase implements FirebaseDatabase {

    public AndroidFirebaseDatabase(FirebaseConfiguration firebaseConfiguration) {
        // Android configuration is made with json file
    }


    @Override
    public DatabaseReference getReference() {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance().getReference();
        return new AndroidDatabaseReference(databaseReference, this);
    }

    @Override
    public DatabaseReference getReference(String s) {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance().getReference(s);
        return new AndroidDatabaseReference(databaseReference, this);
    }

    @Override
    public String getSdkVersion() {
        return com.google.firebase.database.FirebaseDatabase.getSdkVersion();
    }

    @Override
    public synchronized void setPersistenceEnabled(boolean isEnabled) {
        com.google.firebase.database.FirebaseDatabase.getInstance().setPersistenceEnabled(isEnabled);
    }

    @Override
    public synchronized void setLogLevel(LogLevel logLevel) {
        if (logLevel == LogLevel.DEBUG) {
            com.google.firebase.database.FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG);
        }
        if (logLevel == LogLevel.ERROR) {
            com.google.firebase.database.FirebaseDatabase.getInstance().setLogLevel(Logger.Level.ERROR);
        }
        if (logLevel == LogLevel.INFO) {
            com.google.firebase.database.FirebaseDatabase.getInstance().setLogLevel(Logger.Level.INFO);
        }
        if (logLevel == LogLevel.NONE) {
            com.google.firebase.database.FirebaseDatabase.getInstance().setLogLevel(Logger.Level.NONE);
        }
        if (logLevel == LogLevel.WARN) {
            com.google.firebase.database.FirebaseDatabase.getInstance().setLogLevel(Logger.Level.WARN);
        }
    }

    @Override
    public void goOnline() {
        com.google.firebase.database.FirebaseDatabase.getInstance().goOnline();
    }

    @Override
    public void goOffline() {
        com.google.firebase.database.FirebaseDatabase.getInstance().goOffline();
    }

    @Override
    public void purgeOutstandingWrites() {
        com.google.firebase.database.FirebaseDatabase.getInstance().purgeOutstandingWrites();
    }

    @Override
    public DatabaseReference getReferenceFromUrl(String url) {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance().getReferenceFromUrl(url);
        return new AndroidDatabaseReference(databaseReference, this);
    }
}
