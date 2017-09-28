package de.tomgrill.gdxfirebase.core.admob;

public interface RewardedVideoAdListener {
    void onRewardedVideoAdLoaded();

    void onRewardedVideoAdOpened();

    void onRewardedVideoStarted();

    void onRewardedVideoAdClosed();

    void onRewarded(RewardItem rewardItem);

    void onRewardedVideoAdLeftApplication();

    void onRewardedVideoAdFailedToLoad(int errorCode);
}
