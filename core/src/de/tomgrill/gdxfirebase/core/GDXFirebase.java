package de.tomgrill.gdxfirebase.core;

import com.badlogic.gdx.utils.ObjectMap;
import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

public class GDXFirebase {

    public static final String DEFAULT_APP_NAME = "DEFAULT";

    private static ObjectMap<String, FirebaseDatabase> databases = new ObjectMap<>();
    private static ObjectMap<String, FirebaseAuth> auths = new ObjectMap<>();


    static void setFirebaseDatabase(String name, FirebaseDatabase firebaseDatabase) {
        if (!databases.containsKey(name)) {
            databases.put(name, firebaseDatabase);
        } else {
            throw new RuntimeException("Firebase App named [" + name + "] already exist.");
        }
    }

    static void setFirebaseAuth(String name, FirebaseAuth firebaseAuth) {
        if (!auths.containsKey(name)) {
            auths.put(name, firebaseAuth);
        } else {
            throw new RuntimeException("Firebase App named [" + name + "] already exist.");
        }
    }


    public static synchronized FirebaseDatabase FirebaseDatabase() {
        return FirebaseDatabase(DEFAULT_APP_NAME);
    }

    public static synchronized FirebaseAuth FirebaseAuth() {
        return FirebaseAuth(DEFAULT_APP_NAME);
    }

    public static synchronized FirebaseDatabase FirebaseDatabase(String name) {
        if (databases.containsKey(name)) {
            return databases.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }

    public static synchronized FirebaseAuth FirebaseAuth(String name) {
        if (auths.containsKey(name)) {
            return auths.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }
}
