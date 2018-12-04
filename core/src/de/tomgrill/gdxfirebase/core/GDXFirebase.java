package de.tomgrill.gdxfirebase.core;

import com.badlogic.gdx.utils.ObjectMap;
import de.tomgrill.gdxfirebase.core.admob.Admob;
import de.tomgrill.gdxfirebase.core.analytics.FirebaseAnalytics;
import de.tomgrill.gdxfirebase.core.analytics.NullFirebaseAnalytics;
import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.crashlytics.FirebaseCrashlytics;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;
import de.tomgrill.gdxfirebase.core.fcm.FirebaseFCM;

public class GDXFirebase {

    public static final String DEFAULT_APP_NAME = "DEFAULT";

    private static ObjectMap<String, FirebaseDatabase> databases = new ObjectMap<>();
    private static ObjectMap<String, FirebaseAuth> auths = new ObjectMap<>();
    private static ObjectMap<String, FirebaseAnalytics> analytics = new ObjectMap<>();
    private static ObjectMap<String, Admob> admob = new ObjectMap<>();
    private static ObjectMap<String, FirebaseFCM> fcm = new ObjectMap<>();
    private static ObjectMap<String, FirebaseCrashlytics> crashlytics = new ObjectMap<>();

    public static void forceClear() {
        databases.clear();
        auths.clear();
        analytics.clear();
        admob.clear();
        fcm.clear();
        crashlytics.clear();
    }

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

    static void setFirebaseAnalytics(String name, FirebaseAnalytics firebaseAnalytics) {
        if (!analytics.containsKey(name)) {
            analytics.put(name, firebaseAnalytics);
        } else {
            throw new RuntimeException("Firebase App named [" + name + "] already exist.");
        }
    }

    static void setAdmob(String name, Admob admobInstance) {
        if (!admob.containsKey(name)) {
            admob.put(name, admobInstance);
        } else {
            throw new RuntimeException("Firebase App named [" + name + "] already exist.");
        }
    }



    static void setFirebaseCrashlytics(String name, FirebaseCrashlytics firebaseCrashlytics) {
        if (!crashlytics.containsKey(name)) {
            crashlytics.put(name, firebaseCrashlytics);
        } else {
            throw new RuntimeException("Firebase App named [" + name + "] already exist.");
        }
    }

    static void setFirebaseFCM(String name, FirebaseFCM fcmInstance) {
        fcmInstance.frontUpClean();
        if (!fcm.containsKey(name)) {
            fcm.put(name, fcmInstance);
        } else {
            throw new RuntimeException("Firebase App named [" + name + "] already exist.");
        }
    }


    public static synchronized FirebaseDatabase FirebaseDatabase() {
        return FirebaseDatabase(DEFAULT_APP_NAME);
    }

    public static synchronized FirebaseDatabase FirebaseDatabase(String name) {
        if (databases.containsKey(name)) {
            return databases.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }

    public static synchronized FirebaseAuth FirebaseAuth() {
        return FirebaseAuth(DEFAULT_APP_NAME);
    }

    public static synchronized FirebaseAuth FirebaseAuth(String name) {
        if (auths.containsKey(name)) {
            return auths.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }

    public static synchronized FirebaseAnalytics FirebaseAnalytics() {
        return FirebaseAnalytics(DEFAULT_APP_NAME);
    }

    public static synchronized FirebaseAnalytics FirebaseAnalytics(String name) {
        if (analytics.containsKey(name)) {
            return analytics.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }


    public static synchronized Admob Admob() {
        return Admob(DEFAULT_APP_NAME);
    }

    public static synchronized Admob Admob(String name) {
        if (admob.containsKey(name)) {
            return admob.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }


    public static synchronized FirebaseFCM FirebaseFCM() {
        return FirebaseFCM(DEFAULT_APP_NAME);
    }

    public static synchronized FirebaseFCM FirebaseFCM(String name) {
        if (fcm.containsKey(name)) {
            return fcm.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }

    public static synchronized FirebaseCrashlytics FirebaseCrashlytics() {
        return FirebaseCrashlytics(DEFAULT_APP_NAME);
    }

    public static synchronized FirebaseCrashlytics FirebaseCrashlytics(String name) {
        if (crashlytics.containsKey(name)) {
            return crashlytics.get(name);
        }
        throw new RuntimeException("Firebase App named [" + name + "] does not exist.");
    }
}
