package de.tomgrill.gdxfirebase.core.admob;

public class NullVideoRewardAd implements VideoRewardAd {
    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public void load(String adUnit) {

    }

    @Override
    public void show() {

    }

    @Override
    public void setRewardVideoAdListener(RewardedVideoAdListener rewardVideoAdListener) {

    }

    @Override
    public int getErrorCode() {
        return 0;
    }
}
