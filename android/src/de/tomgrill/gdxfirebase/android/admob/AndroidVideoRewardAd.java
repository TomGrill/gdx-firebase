package de.tomgrill.gdxfirebase.android.admob;

import android.app.Activity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import de.tomgrill.gdxfirebase.core.admob.AdmobErrorCode;
import de.tomgrill.gdxfirebase.core.admob.RewardedVideoAdListener;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;

public class AndroidVideoRewardAd implements VideoRewardAd, com.google.android.gms.ads.reward.RewardedVideoAdListener {
    private final AdRequest adRequest;
    private RewardedVideoAd mAd;
    private RewardedVideoAdListener listener;
    private Activity activity;
    private boolean isLoaded;

    private int errorCode = 0;

    public AndroidVideoRewardAd(final Activity activity, final AdRequest adRequest) {
        this.activity = activity;
        this.adRequest = adRequest;

        mAd = MobileAds.getRewardedVideoAdInstance(activity);
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
        isLoaded = false;
        if (listener != null)
            listener.onRewardedVideoAdClosed();
    }

    @Override
    public void onRewarded(com.google.android.gms.ads.reward.RewardItem rewardItem) {
        isLoaded = false;
        if (listener != null)
            listener.onRewarded(new AndroidRewardItem(rewardItem));
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        if (listener != null)
            listener.onRewardedVideoAdLeftApplication();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int error) {
        switch (error) {
            default:
                errorCode = AdmobErrorCode.UNKNOWN_OR_NOT_IMPLEMENTED;
        }
        if (listener != null)
            listener.onRewardedVideoAdFailedToLoad(errorCode);
    }

    @Override
    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public void load(final String adUnit) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAd.loadAd(adUnit, adRequest);
            }
        });

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


        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAd.setRewardedVideoAdListener(AndroidVideoRewardAd.this);
            }
        });
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }
}
