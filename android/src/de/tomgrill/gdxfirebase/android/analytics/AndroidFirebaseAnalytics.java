package de.tomgrill.gdxfirebase.android.analytics;

import android.app.Activity;
import com.badlogic.gdx.utils.ObjectMap;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.analytics.Bundle;
import de.tomgrill.gdxfirebase.core.analytics.FirebaseAnalytics;

public class AndroidFirebaseAnalytics implements FirebaseAnalytics {

    private final FirebaseConfiguration firebaseConfiguration;
    private Activity activity;
    private com.google.firebase.analytics.FirebaseAnalytics mFirebaseAnalytics;

    public AndroidFirebaseAnalytics(Activity activity, FirebaseConfiguration firebaseConfiguration) {
        this.activity = activity;
        this.firebaseConfiguration = firebaseConfiguration;
        mFirebaseAnalytics = com.google.firebase.analytics.FirebaseAnalytics.getInstance(activity); // IDE error can be ignored. PERMISSIONS

        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);

    }

    @Override
    public void logEvent(String name, Bundle bundle) {
        android.os.Bundle androidBundle = new android.os.Bundle();

        for (ObjectMap.Entry<String, CharSequence> entry : bundle.getCharSequenceMap()) {
            androidBundle.putCharSequence(entry.key, entry.value);
        }

        for (ObjectMap.Entry<String, String> entry : bundle.getStringMap()) {
            androidBundle.putString(entry.key, entry.value);
        }

        for (ObjectMap.Entry<String, Character> entry : bundle.getCharMap()) {
            androidBundle.putChar(entry.key, entry.value);
        }

        for (ObjectMap.Entry<String, Integer> entry : bundle.getIntegerMap()) {
            androidBundle.putInt(entry.key, entry.value);
        }

        for (ObjectMap.Entry<String, Long> entry : bundle.getLongMap()) {
            androidBundle.putLong(entry.key, entry.value);
        }

        for (ObjectMap.Entry<String, Float> entry : bundle.getFloatMap()) {
            androidBundle.putFloat(entry.key, entry.value);
        }

        for (ObjectMap.Entry<String, Double> entry : bundle.getDoubleMap()) {
            androidBundle.putDouble(entry.key, entry.value);
        }

        for (ObjectMap.Entry<String, Boolean> entry : bundle.getBooleanMap()) {
            androidBundle.putBoolean(entry.key, entry.value);
        }

        mFirebaseAnalytics.logEvent(name, androidBundle);

    }
}
