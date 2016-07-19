package de.tomgrill.gdxfirebase.desktop;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import de.tomgrill.gdxfirebase.core.DatabaseReference;
import de.tomgrill.gdxfirebase.core.FirebaseDatabase;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;

public class DesktopFirebaseDatabase implements FirebaseDatabase {

    public DesktopFirebaseDatabase(FirebaseConfiguration firebaseConfiguration) {
        FirebaseOptions options = new FirebaseOptions.Builder()

                .setServiceAccount(firebaseConfiguration.serviceAccount.read())
                .setDatabaseUrl(firebaseConfiguration.databaseUrl)
//                .setDatabaseAuthVariableOverride(auth)

                .build();

        FirebaseApp.initializeApp(options);
    }

    @Override
    public DatabaseReference getReference() {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance().getReference();
        return new DesktopDatabaseReference(databaseReference);
    }

    @Override
    public DatabaseReference getReference(String s) {
        com.google.firebase.database.DatabaseReference databaseReference = com.google.firebase.database.FirebaseDatabase.getInstance().getReference(s);
        return new DesktopDatabaseReference(databaseReference);
    }
}
