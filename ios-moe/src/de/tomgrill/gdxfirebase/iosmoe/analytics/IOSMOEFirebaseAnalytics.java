package de.tomgrill.gdxfirebase.iosmoe.analytics;

import apple.foundation.NSDictionary;
import apple.foundation.NSMutableDictionary;
import com.badlogic.gdx.utils.ObjectMap;
import de.tomgrill.gdxfirebase.bindings.firebaseanalytics.FIRAnalytics;
import de.tomgrill.gdxfirebase.bindings.firebasecore.FIRApp;
import de.tomgrill.gdxfirebase.core.analytics.Bundle;
import de.tomgrill.gdxfirebase.core.analytics.FirebaseAnalytics;
import de.tomgrill.gdxfirebase.iosmoe.ConfigureOverwatch;

public class IOSMOEFirebaseAnalytics implements FirebaseAnalytics {

    public IOSMOEFirebaseAnalytics() {
        if(!ConfigureOverwatch.isConfigured) {
            FIRApp.configure();
            ConfigureOverwatch.isConfigured = true;
        }
    }

    @Override
    public void logEvent(String name, Bundle bundle) {
        NSDictionary dictionary = NSMutableDictionary.dictionary();
        //NSDictionary<String, Object> dictionary1 = NSDictionary.dictionary();


        for (ObjectMap.Entry<String, CharSequence> entry : bundle.getCharSequenceMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        for (ObjectMap.Entry<String, String> entry : bundle.getStringMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        for (ObjectMap.Entry<String, Character> entry : bundle.getCharMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        for (ObjectMap.Entry<String, Integer> entry : bundle.getIntegerMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        for (ObjectMap.Entry<String, Long> entry : bundle.getLongMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        for (ObjectMap.Entry<String, Float> entry : bundle.getFloatMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        for (ObjectMap.Entry<String, Double> entry : bundle.getDoubleMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        for (ObjectMap.Entry<String, Boolean> entry : bundle.getBooleanMap()) {
            //dictionary.put(entry.key, String.valueOf(entry.value));
            dictionary.setValueForKey(String.valueOf(entry.value), entry.key);
        }

        FIRAnalytics.logEventWithNameParameters(name, dictionary);
    }
}
