package de.tomgrill.gdxfirebase.android.admob;

import android.app.Activity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import de.tomgrill.gdxfirebase.core.admob.RewardedVideoAdListener;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;

public class AndroidVideoRewardAd implements VideoRewardAd, com.google.android.gms.ads.reward.RewardedVideoAdListener {
    private RewardedVideoAd mAd;
    private final AdRequest adRequest;
    private final String adUnit;
    private RewardedVideoAdListener listener;
    private Activity activity;
    private boolean isLoaded;

    public AndroidVideoRewardAd(final Activity activity, final AdRequest adRequest, final String adUnit) {
        this.activity = activity;

        mAd = MobileAds.getRewardedVideoAdInstance(activity);
        this.adRequest = adRequest;
        this.adUnit = adUnit;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                mAd.setRewardedVideoAdListener(AndroidVideoRewardAd.this);
                mAd.loadAd(adUnit, adRequest);
            }
        });


    }

    @Override
    public void onRewardedVideoAdLoaded() {
        isLoaded = true;
        if (listener != null)
            listener.onRewardedVideoAdLoaded();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        if (listener != null)
            listener.onRewardedVideoAdOpened();
    }

    @Override
    public void onRewardedVideoStarted() {
        if (listener != null)
            listener.onRewardedVideoStarted();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        if (listener != null)
            listener.onRewardedVideoAdClosed();
    }

    @Override
    public void onRewarded(com.google.android.gms.ads.reward.RewardItem rewardItem) {
        if (listener != null)
            listener.onRewarded(new AndroidRewardItem(rewardItem));
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        if (listener != null)
            listener.onRewardedVideoAdLeftApplication();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        if (listener != null)
            listener.onRewardedVideoAdFailedToLoad(i);
    }

    @Override
    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public void show() {
        if (isLoaded()) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mAd.show();
                }
            });
        }
    }

    @Override
    public void setRewardVideoAdListener(final RewardedVideoAdListener rewardVideoAdListener) {
        listener = rewardVideoAdListener;
    }
}
