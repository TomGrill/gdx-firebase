package de.tomgrill.gdxfirebase.android.crashlytics;

import android.app.Activity;
import com.crashlytics.android.Crashlytics;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.crashlytics.FirebaseCrashlytics;
import io.fabric.sdk.android.Fabric;

public class AndroidCrashlytics implements FirebaseCrashlytics {

    private final FirebaseConfiguration firebaseConfiguration;
    private Activity activity;

    private boolean enabled = false;

    public AndroidCrashlytics(Activity activity, FirebaseConfiguration firebaseConfiguration) {
        this.activity = activity;
        this.firebaseConfiguration = firebaseConfiguration;
    }

    @Override
    public void enable() {
        if(enabled) return;
        Fabric.with(activity, new Crashlytics());
        enabled = true;
    }

    @Override
    public void setBool(String key, boolean value) {
        if(!enabled) return;
        Crashlytics.setBool(key, value);
    }

    @Override
    public void setDouble(String key, double value) {
        if(!enabled) return;
        Crashlytics.setDouble(key, value);

    }

    @Override
    public void setFloat(String key, float value) {
        if(!enabled) return;
        Crashlytics.setFloat(key, value);

    }

    @Override
    public void setLong(String key, long value) {
        if(!enabled) return;
        Crashlytics.setLong(key, value);

    }

    @Override
    public void setString(String key, String value) {
        if(!enabled) return;
        Crashlytics.setString(key, value);

    }

    @Override
    public void setInt(String key, int value) {
        if(!enabled) return;
        Crashlytics.setInt(key, value);

    }

    @Override
    public void setUserIdentifier(String identifier) {
        if(!enabled) return;
        Crashlytics.setUserIdentifier(identifier);

    }

    @Override
    public void setUserName(String name) {
        if(!enabled) return;
        Crashlytics.setUserName(name);

    }

    @Override
    public void setUserEmail(String email) {
        if(!enabled) return;
        Crashlytics.setUserEmail(email);

    }

    @Override
    public void logException(Exception e) {
        if(!enabled) return;
        Crashlytics.logException(e);

    }

    @Override
    public void log(String message) {
        if(!enabled) return;
        Crashlytics.log(message);

    }

    @Override
    public void log(int priority, String tag, String message) {
        if(!enabled) return;
        Crashlytics.log(priority, tag, message);

    }
}
