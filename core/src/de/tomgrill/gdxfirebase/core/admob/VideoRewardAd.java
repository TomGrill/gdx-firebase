package de.tomgrill.gdxfirebase.core.admob;

public interface VideoRewardAd {

    boolean isLoaded();

    void show();

    void setRewardVideoAdListener(RewardedVideoAdListener rewardVideoAdListener);
}
