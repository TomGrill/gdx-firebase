package de.tomgrill.gdxfirebase.core.admob;

public interface VideoRewardAd {

    boolean isLoaded();

    void load(String adUnit);

    void show();

    void setRewardVideoAdListener(RewardedVideoAdListener rewardVideoAdListener);

    int getErrorCode();
}
