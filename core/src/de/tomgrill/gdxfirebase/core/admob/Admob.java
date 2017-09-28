package de.tomgrill.gdxfirebase.core.admob;

public interface Admob {

    VideoRewardAd loadVideoRewardAd(String adUnit);

    boolean isTestDevice();
}
