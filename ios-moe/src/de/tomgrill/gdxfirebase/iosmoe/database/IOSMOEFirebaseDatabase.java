package de.tomgrill.gdxfirebase.iosmoe.database;

import com.google.firebasecore.FIRApp;
import com.google.firebasedatabase.FIRDatabase;
import de.tomgrill.gdxfirebase.core.LogLevel;
import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;
import de.tomgrill.gdxfirebase.iosmoe.ConfigureOverwatch;

public class IOSMOEFirebaseDatabase implements FirebaseDatabase {

    private FIRDatabase firDatabase;

    public IOSMOEFirebaseDatabase(FIRDatabase firDatabase) {
        if (!ConfigureOverwatch.isConfigured) {
            FIRApp.configure();
            ConfigureOverwatch.isConfigured = true;
        }

        this.firDatabase = firDatabase;
    }

    @Override
    public DatabaseReference getReference() {
        return new IOSMOEDatabaseReference(firDatabase.reference(), firDatabase);
    }

    @Override
    public DatabaseReference getReference(String s) {
        return new IOSMOEDatabaseReference(firDatabase.referenceWithPath(s), firDatabase);
    }

    @Override
    public String getSdkVersion() {
        return "SDK-NO-VALUE";
    }

    @Override
    public void setPersistenceEnabled(boolean isEnabled) {
        firDatabase.setPersistenceEnabled(isEnabled);
    }

    @Override
    public void setLogLevel(LogLevel logLevel) {
        //
    }

    @Override
    public void goOnline() {
        firDatabase.goOnline();
    }

    @Override
    public void goOffline() {
        firDatabase.goOffline();
    }

    @Override
    public void purgeOutstandingWrites() {
        firDatabase.purgeOutstandingWrites();
    }

    @Override
    public DatabaseReference getReferenceFromUrl(String url) {
        return new IOSMOEDatabaseReference(firDatabase.referenceFromURL(url), firDatabase);
    }
}
