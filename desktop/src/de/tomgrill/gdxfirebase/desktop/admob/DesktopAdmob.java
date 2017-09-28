package de.tomgrill.gdxfirebase.desktop.admob;

import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.admob.Admob;
import de.tomgrill.gdxfirebase.core.admob.NullVideoRewardAd;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;

public class DesktopAdmob implements Admob {
    public DesktopAdmob(String name, FirebaseConfiguration firebaseConfiguration) {
    }

    @Override
    public VideoRewardAd loadVideoRewardAd(String adUnit) {
        return new NullVideoRewardAd();
    }

    @Override
    public boolean isTestDevice() {
        return true;
    }
}
