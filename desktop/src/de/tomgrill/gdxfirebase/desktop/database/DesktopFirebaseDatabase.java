package de.tomgrill.gdxfirebase.desktop.database;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.Logger;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.GDXFirebase;
import de.tomgrill.gdxfirebase.core.LogLevel;
import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

import java.util.HashMap;

public class DesktopFirebaseDatabase implements FirebaseDatabase {

    private FirebaseApp app;

    public DesktopFirebaseDatabase(String name, FirebaseConfiguration firebaseConfiguration) {
        FirebaseOptions.Builder builder = new FirebaseOptions.Builder()

                .setServiceAccount(firebaseConfiguration.serviceAccount.read())
                .setDatabaseUrl(firebaseConfiguration.databaseUrl);


        if (firebaseConfiguration.desktopFirebaseUser != null) {
            HashMap<String, Object> auth = new HashMap<>();
            auth.put("uid", firebaseConfiguration.desktopFirebaseUser.getUid());
            builder.setDatabaseAuthVariableOverride(auth);
        }

        if (name.equals(GDXFirebase.DEFAULT_APP_NAME)) {
            app = FirebaseApp.initializeApp(builder.build());
        } else {
            app = FirebaseApp.initializeApp(builder.build(), name);
        }

    }

    @Override
    public DatabaseReference getReference() {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance(app).getReference();
        return new DesktopDatabaseReference(databaseReference, this);
    }

    @Override
    public DatabaseReference getReference(String s) {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance(app).getReference(s);
        return new DesktopDatabaseReference(databaseReference, this);
    }

    @Override
    public String getSdkVersion() {
        return com.google.firebase.database.FirebaseDatabase.getSdkVersion();
    }

    @Override
    public synchronized void setPersistenceEnabled(boolean isEnabled) {
        com.google.firebase.database.FirebaseDatabase.getInstance(app).setPersistenceEnabled(isEnabled);
    }

    @Override
    public synchronized void setLogLevel(LogLevel logLevel) {
        if (logLevel == LogLevel.DEBUG) {
            com.google.firebase.database.FirebaseDatabase.getInstance(app).setLogLevel(Logger.Level.DEBUG);
        }
        if (logLevel == LogLevel.ERROR) {
            com.google.firebase.database.FirebaseDatabase.getInstance(app).setLogLevel(Logger.Level.ERROR);
        }
        if (logLevel == LogLevel.INFO) {
            com.google.firebase.database.FirebaseDatabase.getInstance(app).setLogLevel(Logger.Level.INFO);
        }
        if (logLevel == LogLevel.NONE) {
            com.google.firebase.database.FirebaseDatabase.getInstance(app).setLogLevel(Logger.Level.NONE);
        }
        if (logLevel == LogLevel.WARN) {
            com.google.firebase.database.FirebaseDatabase.getInstance(app).setLogLevel(Logger.Level.WARN);
        }
    }

    @Override
    public void goOnline() {
        com.google.firebase.database.FirebaseDatabase.getInstance(app).goOnline();
    }

    @Override
    public void goOffline() {
        com.google.firebase.database.FirebaseDatabase.getInstance(app).goOffline();
    }

    @Override
    public void purgeOutstandingWrites() {
        com.google.firebase.database.FirebaseDatabase.getInstance(app).purgeOutstandingWrites();
    }

    @Override
    public DatabaseReference getReferenceFromUrl(String url) {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance(app).getReferenceFromUrl(url);
        return new DesktopDatabaseReference(databaseReference, this);
    }
}
