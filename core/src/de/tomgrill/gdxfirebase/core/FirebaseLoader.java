package de.tomgrill.gdxfirebase.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class FirebaseLoader {

    public static void load(FirebaseConfiguration firebaseConfiguration) {
        Object loaderObj = null;
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.android.AndroidFirebaseDatabase");
            }

            if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.desktop.DesktopFirebaseDatabase");

            }


            if (loaderCls != null) {

                loaderObj = ClassReflection.getConstructor(loaderCls, FirebaseConfiguration.class).newInstance(firebaseConfiguration);
                Gdx.app.debug("gdx-firebase", "gdx-firebase for " + Gdx.app.getType() + " installed successfully.");
                GDXFirebase.setFirebaseDatabase((de.tomgrill.gdxfirebase.core.database.FirebaseDatabase) loaderObj);

            } else {
                Gdx.app.debug("gdx-firebase", "gdx-firebase NOT LOADED for " + Gdx.app.getType());
            }


        } catch (ReflectionException e) {
            e.printStackTrace();

        }
    }
}
