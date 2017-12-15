package de.tomgrill.gdxfirebase.core;

import com.badlogic.gdx.files.FileHandle;
import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.auth.FirebaseUser;

public class FirebaseConfiguration {

    public FileHandle serviceAccount;
    public String databaseUrl;

    //public String androidDefaultWebClientId = "";
    //public String iosDefaultWebClientId = "";

    public FirebaseUser desktopFirebaseUser;
    public FirebaseAuth desktopFirebaseAuth;
    public String admobAppId;
    public boolean admobUseTestDevice = true;

    public String fcmKeyPrefix = "your_app_name.";
}
