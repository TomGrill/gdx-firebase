package de.tomgrill.gdxfirebase.iosmoe.admob;

import com.google.googlemobileads.GADAdReward;
import de.tomgrill.gdxfirebase.core.admob.RewardItem;

public class IOSMOERewardItem implements RewardItem {


    private GADAdReward reward;

    public IOSMOERewardItem(GADAdReward reward) {

        this.reward = reward;
    }

    @Override
    public String getType() {
        return reward.type();
    }

    @Override
    public int getAmount() {
        return reward.amount().intValue();
    }
}
