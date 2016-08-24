package de.tomgrill.gdxfirebase.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

public class FirebaseLoader {

    public static void load(FirebaseConfiguration firebaseConfiguration, FirebaseFeatures... enabledFeatures) {

        for (FirebaseFeatures feature : enabledFeatures) {
            if (feature == FirebaseFeatures.REALTIME_DATABASE) {
                loadRealtimeDatabase(firebaseConfiguration);
            }
            if (feature == FirebaseFeatures.AUTHENTICATION) {
                loadAuthentication(firebaseConfiguration);
            }
        }


    }

    private static void loadAuthentication(FirebaseConfiguration firebaseConfiguration) {
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


            if (loaderCls != null) {
                Object loaderObj = ClassReflection.getConstructor(loaderCls, FirebaseConfiguration.class).newInstance(firebaseConfiguration);
                Gdx.app.debug("gdx-firebase", "Authentication for " + Gdx.app.getType() + " installed successfully with default implementation.");
                GDXFirebase.setFirebaseAuth((FirebaseAuth) loaderObj);




            } else if (firebaseConfiguration.desktopFirebaseAuth != null) {
                Gdx.app.debug("gdx-firebase", "Authentication for " + Gdx.app.getType() + " installed successfully with custom user implementation.");
                GDXFirebase.setFirebaseAuth(firebaseConfiguration.desktopFirebaseAuth);
            } else {
                Gdx.app.debug("gdx-firebase", "Authentication NOT LOADED for " + Gdx.app.getType());
            }


        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }

    private static void loadRealtimeDatabase(FirebaseConfiguration firebaseConfiguration) {
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.android.database.AndroidFirebaseDatabase");
            }

            if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.desktop.database.DesktopFirebaseDatabase");

            }


            if (loaderCls != null) {

                Object loaderObj = ClassReflection.getConstructor(loaderCls, FirebaseConfiguration.class).newInstance(firebaseConfiguration);
                Gdx.app.debug("gdx-firebase", "Realtime Database for " + Gdx.app.getType() + " installed successfully.");
                GDXFirebase.setFirebaseDatabase((FirebaseDatabase) loaderObj);

            } else {
                Gdx.app.debug("gdx-firebase", "Realtime Database NOT LOADED for " + Gdx.app.getType());
            }


        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }
}
