package de.tomgrill.gdxfirebase.core.crashlytics;

public interface FirebaseCrashlytics {

    /** enables Crashlytics on this platform. There is no disable, restart required cause Android */
    void enable();

    void setBool(String key, boolean value);

    void setDouble(String key, double value);

    void setFloat(String key, float value);

    void setLong(String key, long value);

    void setString(String key, String value);

    void setInt(String key, int value);

    void setUserIdentifier(String identifier);

    void setUserName(String name);

    void setUserEmail(String email);

    void logException(Exception e);

    void log(String message);

    void log(int priority, String tag, String message);

}
