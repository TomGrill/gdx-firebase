package de.tomgrill.gdxfirebase.core.analytics;

import com.badlogic.gdx.utils.ObjectMap;

public class Bundle {
    private ObjectMap<String, CharSequence> charSequenceMap = new ObjectMap<>();
    private ObjectMap<String, String> stringMap = new ObjectMap<>();
    private ObjectMap<String, Character> charMap = new ObjectMap<>();
    private ObjectMap<String, Integer> integerMap = new ObjectMap<>();
    private ObjectMap<String, Long> longMap = new ObjectMap<>();
    private ObjectMap<String, Float> floatMap = new ObjectMap<>();
    private ObjectMap<String, Double> doubleMap = new ObjectMap<>();
    private ObjectMap<String, Boolean> booleanMap = new ObjectMap<>();

    public ObjectMap<String, Boolean> getBooleanMap() {
        return booleanMap;
    }

    public ObjectMap<String, String> getStringMap() {
        return stringMap;
    }

    public ObjectMap<String, Character> getCharMap() {
        return charMap;
    }

    public ObjectMap<String, Integer> getIntegerMap() {
        return integerMap;
    }

    public ObjectMap<String, Long> getLongMap() {
        return longMap;
    }

    public ObjectMap<String, Float> getFloatMap() {
        return floatMap;
    }

    public ObjectMap<String, Double> getDoubleMap() {
        return doubleMap;
    }

    public void putCharSequence(String key, CharSequence value) {
        charSequenceMap.put(key, value);
    }

    public void putString(String key, String value) {
        stringMap.put(key, value);
    }

    public void putChar(String key, char value) {
        charMap.put(key, value);
    }

    public void putInt(String key, int value) {
        integerMap.put(key, value);
    }

    public void putLong(String key, long value) {
        longMap.put(key, value);
    }

    public void putFloat(String key, float value) {
        floatMap.put(key, value);
    }

    public void putDouble(String key, double value) {
        doubleMap.put(key, value);
    }

    public void putBoolean(String key, boolean value) {
        booleanMap.put(key, value);
    }

    public ObjectMap<String, CharSequence> getCharSequenceMap() {
        return charSequenceMap;
    }

}
