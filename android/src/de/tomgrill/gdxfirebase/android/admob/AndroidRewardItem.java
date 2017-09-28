package de.tomgrill.gdxfirebase.android.admob;

import de.tomgrill.gdxfirebase.core.admob.RewardItem;

public class AndroidRewardItem implements RewardItem {
    private final com.google.android.gms.ads.reward.RewardItem rewardItem;

    public AndroidRewardItem(com.google.android.gms.ads.reward.RewardItem rewardItem) {
        this.rewardItem = rewardItem;
    }

    @Override
    public String getType() {
        return rewardItem.getType();
    }

    @Override
    public int getAmount() {
        return rewardItem.getAmount();
    }

    @Override
    public String toString() {
        return "Android Reward Item: {Type: " + getType() + ", Amount: " + getAmount() + "}";
    }
}
