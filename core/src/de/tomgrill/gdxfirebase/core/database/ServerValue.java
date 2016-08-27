package de.tomgrill.gdxfirebase.core.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServerValue {

    public static final Map<String, String> TIMESTAMP = createServerValuePlaceholder("timestamp");

    public ServerValue() {
    }

    private static Map<String, String> createServerValuePlaceholder(String key) {
        HashMap result = new HashMap();
        result.put(".sv", key);
        return Collections.unmodifiableMap(result);
    }
}
