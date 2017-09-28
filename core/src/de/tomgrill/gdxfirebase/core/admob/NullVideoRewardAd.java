package de.tomgrill.gdxfirebase.core.admob;

public class NullVideoRewardAd implements VideoRewardAd {
    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public void show() {

    }

    @Override
    public void setRewardVideoAdListener(RewardedVideoAdListener rewardVideoAdListener) {

    }
}
