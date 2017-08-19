package de.tomgrill.gdxfirebase.desktop.analytics;

import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.analytics.Bundle;
import de.tomgrill.gdxfirebase.core.analytics.FirebaseAnalytics;

public class DesktopFirebaseAnalytics implements FirebaseAnalytics {

    private FirebaseConfiguration firebaseConfiguration;

    public DesktopFirebaseAnalytics(String name, FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
    }

    @Override
    public void logEvent(String name, Bundle bundle) {

    }
}
