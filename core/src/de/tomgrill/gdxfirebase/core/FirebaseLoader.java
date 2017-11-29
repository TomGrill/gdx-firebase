package de.tomgrill.gdxfirebase.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import de.tomgrill.gdxfirebase.core.admob.Admob;
import de.tomgrill.gdxfirebase.core.analytics.FirebaseAnalytics;
import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;
import de.tomgrill.gdxfirebase.core.fcm.FirebaseFCM;

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
            if (feature == FirebaseFeatures.ANALYTICS) {
                loadAnalytics(name, firebaseConfiguration);
            }
            if (feature == FirebaseFeatures.ADMOB) {
                loadAdmob(name, firebaseConfiguration);
            }
            if (feature == FirebaseFeatures.FCM) {
                loadFCM(name, firebaseConfiguration);
            }
        }
    }

    private static void loadFCM(String name, FirebaseConfiguration firebaseConfiguration) {
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {

                Class<?> activityClazz = ClassReflection.forName("android.app.Activity");

                Class<?> firebaseFCMClazz = ClassReflection.forName("de.tomgrill.gdxfirebase.android.fcm.AndroidFirebaseFCM");

                Object activity = null;

                Class<?> gdxClazz = ClassReflection.forName("com.badlogic.gdx.Gdx");
                Object gdxAppObject = ClassReflection.getField(gdxClazz, "app").get(null);

                if (ClassReflection.isAssignableFrom(activityClazz, gdxAppObject.getClass())) {

                    activity = gdxAppObject;
                } else {

                    Class<?> supportFragmentClass = findClass("android.support.v4.app.Fragment");
                    // {
                    if (supportFragmentClass != null && ClassReflection.isAssignableFrom(supportFragmentClass, gdxAppObject.getClass())) {

                        activity = ClassReflection.getMethod(supportFragmentClass, "getActivity").invoke(gdxAppObject);
                    } else {
                        Class<?> fragmentClass = findClass("android.app.Fragment");
                        if (fragmentClass != null && ClassReflection.isAssignableFrom(fragmentClass, gdxAppObject.getClass())) {
                            activity = ClassReflection.getMethod(fragmentClass, "getActivity").invoke(gdxAppObject);
                        }
                    }

                }

                if (activity == null) {
                    throw new RuntimeException("Can't find your gdx activity to instantiate gdx-firebase. " + "Looks like you have implemented AndroidApplication without using "
                            + "Activity or Fragment classes or Activity is not available at the moment");
                }

                Object firebaseFCM = ClassReflection.getConstructor(firebaseFCMClazz, activityClazz, FirebaseConfiguration.class).newInstance(activity, firebaseConfiguration);

                Class<?> gdxLifecycleListenerClazz = ClassReflection.forName("com.badlogic.gdx.LifecycleListener");
                Method gdxAppAddLifecycleListenerMethod = ClassReflection.getMethod(gdxAppObject.getClass(), "addLifecycleListener", gdxLifecycleListenerClazz);

                gdxAppAddLifecycleListenerMethod.invoke(gdxAppObject, firebaseFCM);

                GDXFirebase.setFirebaseFCM(name, (FirebaseFCM) firebaseFCM);

                Gdx.app.debug("gdx-firebase", "FCM loaded for " + Gdx.app.getType());


                return;

            }
        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }

    private static void loadAnalytics(String name, FirebaseConfiguration firebaseConfiguration) {
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {

                Class<?> activityClazz = ClassReflection.forName("android.app.Activity");

                Class<?> firebaseAnalyticsClazz = ClassReflection.forName("de.tomgrill.gdxfirebase.android.analytics.AndroidFirebaseAnalytics");

                Object activity = null;

                Class<?> gdxClazz = ClassReflection.forName("com.badlogic.gdx.Gdx");
                Object gdxAppObject = ClassReflection.getField(gdxClazz, "app").get(null);

                if (ClassReflection.isAssignableFrom(activityClazz, gdxAppObject.getClass())) {

                    activity = gdxAppObject;
                } else {

                    Class<?> supportFragmentClass = findClass("android.support.v4.app.Fragment");
                    // {
                    if (supportFragmentClass != null && ClassReflection.isAssignableFrom(supportFragmentClass, gdxAppObject.getClass())) {

                        activity = ClassReflection.getMethod(supportFragmentClass, "getActivity").invoke(gdxAppObject);
                    } else {
                        Class<?> fragmentClass = findClass("android.app.Fragment");
                        if (fragmentClass != null && ClassReflection.isAssignableFrom(fragmentClass, gdxAppObject.getClass())) {
                            activity = ClassReflection.getMethod(fragmentClass, "getActivity").invoke(gdxAppObject);
                        }
                    }

                }

                if (activity == null) {
                    throw new RuntimeException("Can't find your gdx activity to instantiate gdx-firebase. " + "Looks like you have implemented AndroidApplication without using "
                            + "Activity or Fragment classes or Activity is not available at the moment");
                }
                Object firebaseAnalytics = ClassReflection.getConstructor(firebaseAnalyticsClazz, activityClazz, FirebaseConfiguration.class).newInstance(activity, firebaseConfiguration);

                GDXFirebase.setFirebaseAnalytics(name, (FirebaseAnalytics) firebaseAnalytics);

                Gdx.app.debug("gdx-firebase", "Analytics loaded for " + Gdx.app.getType());


                return;

            }

            if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.desktop.analytics.DesktopFirebaseAnalytics");
                if (loaderCls != null) {
                    Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
                    GDXFirebase.setFirebaseAnalytics(name, (FirebaseAnalytics) loaderObj);
                    Gdx.app.debug("gdx-firebase", "Analytics for " + Gdx.app.getType() + " installed successfully with default implementation.");
                } else {
                    Gdx.app.debug("gdx-firebase", "Analytics NOT LOADED for " + Gdx.app.getType());
                }
                return;
            }


            if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                try {
                    loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.iosmoe.analytics.IOSMOEFirebaseAnalytics");
                    if (loaderCls != null) {
                        //Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
                        Object loaderObj = ClassReflection.getConstructor(loaderCls).newInstance();

                        GDXFirebase.setFirebaseAnalytics(name, (FirebaseAnalytics) loaderObj);
                        Gdx.app.debug("gdx-firebase", "Analytics for " + Gdx.app.getType() + " installed successfully with default implementation.");
                    } else {
                        Gdx.app.debug("gdx-firebase", "Analytics NOT LOADED for " + Gdx.app.getType());
                    }
                    return;
                } catch (ReflectionException e) {
                    e.printStackTrace();
                }
            }

//            if(firebaseConfiguration.desktopFirebaseAuth != null) {
//                GDXFirebase.setFirebaseAuth(name, firebaseConfiguration.desktopFirebaseAuth);
//                Gdx.app.debug("gdx-firebase", "Authentication for " + Gdx.app.getType() + " installed successfully with custom user implementation.");
//            } else {
//                if (loaderCls != null) {
//                    Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
//                    GDXFirebase.setFirebaseAuth(name, (FirebaseAuth) loaderObj);
//                    Gdx.app.debug("gdx-firebase", "Authentication for " + Gdx.app.getType() + " installed successfully with default implementation.");
//                } else {
//                    Gdx.app.debug("gdx-firebase", "Authentication NOT LOADED for " + Gdx.app.getType());
//                }
//            }

        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }

    private static void loadAdmob(String name, FirebaseConfiguration firebaseConfiguration) {
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
//                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.android.auth.AndroidFirebaseAuth");

                Class<?> activityClazz = ClassReflection.forName("android.app.Activity");

                Class<?> firebaseAuthClazz = ClassReflection.forName("de.tomgrill.gdxfirebase.android.admob.AndroidAdmob");

                Object activity = null;

                Class<?> gdxClazz = ClassReflection.forName("com.badlogic.gdx.Gdx");
                Object gdxAppObject = ClassReflection.getField(gdxClazz, "app").get(null);

                if (ClassReflection.isAssignableFrom(activityClazz, gdxAppObject.getClass())) {

                    activity = gdxAppObject;
                } else {

                    Class<?> supportFragmentClass = findClass("android.support.v4.app.Fragment");
                    // {
                    if (supportFragmentClass != null && ClassReflection.isAssignableFrom(supportFragmentClass, gdxAppObject.getClass())) {

                        activity = ClassReflection.getMethod(supportFragmentClass, "getActivity").invoke(gdxAppObject);
                    } else {
                        Class<?> fragmentClass = findClass("android.app.Fragment");
                        if (fragmentClass != null && ClassReflection.isAssignableFrom(fragmentClass, gdxAppObject.getClass())) {
                            activity = ClassReflection.getMethod(fragmentClass, "getActivity").invoke(gdxAppObject);
                        }
                    }

                }

                if (activity == null) {
                    throw new RuntimeException("Can't find your gdx activity to instantiate gdx-firebase. " + "Looks like you have implemented AndroidApplication without using "
                            + "Activity or Fragment classes or Activity is not available at the moment");
                }
                Object firebaseAuth = ClassReflection.getConstructor(firebaseAuthClazz, activityClazz, FirebaseConfiguration.class).newInstance(activity, firebaseConfiguration);

                GDXFirebase.setAdmob(name, (Admob) firebaseAuth);

                Gdx.app.debug("gdx-firebase", "Admob loaded for " + Gdx.app.getType());


                return;

            }

            if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.desktop.admob.DesktopAdmob");
            }

            if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                try {
                    loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.iosmoe.admob.IOSMOEAdmob");
                    if (loaderCls != null) {
                        //Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
                        Object loaderObj = ClassReflection.getConstructor(loaderCls).newInstance();

                        if (loaderObj instanceof FirebaseConfigurationHolder) {
                            ((FirebaseConfigurationHolder) loaderObj).setFirebaseConfiguration(firebaseConfiguration);
                        }
                        GDXFirebase.setAdmob(name, (Admob) loaderObj);
                        Gdx.app.debug("gdx-firebase", "Admob for " + Gdx.app.getType() + " installed successfully with default implementation.");
                    } else {
                        Gdx.app.debug("gdx-firebase", "Admob NOT LOADED for " + Gdx.app.getType());
                    }
                    return;
                } catch (ReflectionException e) {
                    e.printStackTrace();
                }
            }


            if (loaderCls != null) {
                Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
                GDXFirebase.setAdmob(name, (Admob) loaderObj);
                Gdx.app.debug("gdx-firebase", "Admob for " + Gdx.app.getType() + " installed successfully with default implementation.");
            } else {
                Gdx.app.debug("gdx-firebase", "Admob NOT LOADED for " + Gdx.app.getType());
            }


        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }

    private static void loadAuthentication(String name, FirebaseConfiguration firebaseConfiguration) {
        Class<?> loaderCls = null;

        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
//                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.android.auth.AndroidFirebaseAuth");

                Class<?> activityClazz = ClassReflection.forName("android.app.Activity");

                Class<?> firebaseAuthClazz = ClassReflection.forName("de.tomgrill.gdxfirebase.android.auth.AndroidFirebaseAuth");

                Object activity = null;

                Class<?> gdxClazz = ClassReflection.forName("com.badlogic.gdx.Gdx");
                Object gdxAppObject = ClassReflection.getField(gdxClazz, "app").get(null);

                if (ClassReflection.isAssignableFrom(activityClazz, gdxAppObject.getClass())) {

                    activity = gdxAppObject;
                } else {

                    Class<?> supportFragmentClass = findClass("android.support.v4.app.Fragment");
                    // {
                    if (supportFragmentClass != null && ClassReflection.isAssignableFrom(supportFragmentClass, gdxAppObject.getClass())) {

                        activity = ClassReflection.getMethod(supportFragmentClass, "getActivity").invoke(gdxAppObject);
                    } else {
                        Class<?> fragmentClass = findClass("android.app.Fragment");
                        if (fragmentClass != null && ClassReflection.isAssignableFrom(fragmentClass, gdxAppObject.getClass())) {
                            activity = ClassReflection.getMethod(fragmentClass, "getActivity").invoke(gdxAppObject);
                        }
                    }

                }

                if (activity == null) {
                    throw new RuntimeException("Can't find your gdx activity to instantiate gdx-firebase. " + "Looks like you have implemented AndroidApplication without using "
                            + "Activity or Fragment classes or Activity is not available at the moment");
                }
                Object firebaseAuth = ClassReflection.getConstructor(firebaseAuthClazz, activityClazz, FirebaseConfiguration.class).newInstance(activity, firebaseConfiguration);

                GDXFirebase.setFirebaseAuth(name, (FirebaseAuth) firebaseAuth);

                Gdx.app.debug("gdx-firebase", "Authentication loaded for " + Gdx.app.getType());


                return;

            }

            if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
                if (firebaseConfiguration.desktopFirebaseAuth == null) {
                    loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.desktop.auth.DefaultDesktopFirebaseAuth");
                }
            }


            if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                try {
                    loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.iosmoe.auth.IOSMOEFirebaseAuth");
                    if (loaderCls != null) {
                        //Object loaderObj = ClassReflection.getConstructor(loaderCls, String.class, FirebaseConfiguration.class).newInstance(name, firebaseConfiguration);
                        Object loaderObj = ClassReflection.getConstructor(loaderCls).newInstance();

                        GDXFirebase.setFirebaseAuth(name, (FirebaseAuth) loaderObj);
                        Gdx.app.debug("gdx-firebase", "Auth for " + Gdx.app.getType() + " installed successfully with default implementation.");
                    } else {
                        Gdx.app.debug("gdx-firebase", "Auth NOT LOADED for " + Gdx.app.getType());
                    }
                    return;
                } catch (ReflectionException e) {
                    e.printStackTrace();
                }
            }


            if (firebaseConfiguration.desktopFirebaseAuth != null) {
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

    private static Class<?> findClass(String name) {
        try {
            return ClassReflection.forName(name);
        } catch (Exception e) {
            return null;
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

            if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                loaderCls = ClassReflection.forName("de.tomgrill.gdxfirebase.iosmoe.database.IOSMOEFirebaseDatabase");

                Object loaderObj = ClassReflection.getConstructor(loaderCls).newInstance();
                GDXFirebase.setFirebaseDatabase(name, (FirebaseDatabase) loaderObj);
                Gdx.app.debug("gdx-firebase", "Realtime Database for " + Gdx.app.getType() + " installed successfully.");


                return;
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
