package de.tomgrill.gdxfirebase.core.database;

import de.tomgrill.gdxfirebase.core.LogLevel;

public interface FirebaseDatabase {

    DatabaseReference getReference();

    DatabaseReference getReference(String s);

    String getSdkVersion();

    void setPersistenceEnabled(boolean isEnabled);

    void setLogLevel(LogLevel logLevel);

    void goOnline();

    void goOffline();

    void purgeOutstandingWrites();

    DatabaseReference getReferenceFromUrl(String url);

//    FirebaseApp getApp(); TODO
}
