package de.tomgrill.gdxfirebase.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

public class FirebaseLoader {

    public static void load(FirebaseConfiguration firebaseConfiguration, FirebaseFeatures... enabledFeatures) {
        load(GDXFirebase.DEFAULT_APP_NAME, firebaseConfiguration, enabledFeatures);
    }

    public static void load(String name, FirebaseConfiguration firebaseConfiguration, FirebaseFeatures... enabledFeatures) {

        // TODO implement duplicate feature check

        for (FirebaseFeatures feature : enabledFeatures) {
            if (feature == FirebaseFeatures.REALTIME_DATABASE) {
                loadRealtimeDatabase(name, firebaseConfiguration);
            }
            if (feature == FirebaseFeatures.AUTHENTICATION) {
                loadAuthentication(name, firebaseConfiguration);
            }
        }


    }

    private static void loadAuthentication(String name, FirebaseConfiguration firebaseConfiguration) {
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.android.auth.AndroidFirebaseAuth");
            }

            if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
                if (firebaseConfiguration.desktopFirebaseAuth == null) {
                    loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.desktop.auth.DefaultDesktopFirebaseAuth");
                }
            }


            if(firebaseConfiguration.desktopFirebaseAuth != null) {
                GDXFirebase.setFirebaseAuth(name, firebaseConfiguration.desktopFirebaseAuth);
                Gdx.app.debug("gdx-firebase", "Authentication for " + Gdx.app.getType() + " installed successfully with custom user implementation.");
            } else {
                if (loaderCls != null) {
                    Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
                    GDXFirebase.setFirebaseAuth(name, (FirebaseAuth) loaderObj);
                    Gdx.app.debug("gdx-firebase", "Authentication for " + Gdx.app.getType() + " installed successfully with default implementation.");
                } else {
                    Gdx.app.debug("gdx-firebase", "Authentication NOT LOADED for " + Gdx.app.getType());
                }
            }

        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }

    private static void loadRealtimeDatabase(String name, FirebaseConfiguration firebaseConfiguration) {
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.android.database.AndroidFirebaseDatabase");
            }

            if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.desktop.database.DesktopFirebaseDatabase");
            }


            if (loaderCls != null) {

                Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
                GDXFirebase.setFirebaseDatabase(name, (FirebaseDatabase) loaderObj);
                Gdx.app.debug("gdx-firebase", "Realtime Database for " + Gdx.app.getType() + " installed successfully.");

            } else {
                Gdx.app.debug("gdx-firebase", "Realtime Database NOT LOADED for " + Gdx.app.getType());
            }


        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }
}
