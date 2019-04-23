package de.tomgrill.gdxfirebase.iosmoe.admob;

import android.os.Bundle;
import apple.NSObject;
import apple.foundation.*;
import apple.uikit.UIDevice;
import apple.uikit.UIScreen;
import apple.uikit.UIViewController;
import apple.uikit.UIWindow;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.iosmoe.IOSApplication;
import com.google.googlemobileads.GADAdReward;
import com.google.googlemobileads.GADExtras;
import com.google.googlemobileads.GADRequest;
import com.google.googlemobileads.GADRewardBasedVideoAd;
import com.google.googlemobileads.enums.GADErrorCode;
import com.google.googlemobileads.protocol.GADAdNetworkExtras;
import com.google.googlemobileads.protocol.GADRewardBasedVideoAdDelegate;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.admob.AdmobErrorCode;
import de.tomgrill.gdxfirebase.core.admob.RewardedVideoAdListener;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;
import org.moe.natj.objc.ann.Selector;

public class IOSMOEVideoRewardAd implements VideoRewardAd, GADRewardBasedVideoAdDelegate {

    private RewardedVideoAdListener listener;

    private UIViewController controller;

    private FirebaseConfiguration firebaseConfiguration;
    private boolean nonPersonalizedAds;

    private UIWindow windows;

    private volatile int errorCode = 0;

    public IOSMOEVideoRewardAd(FirebaseConfiguration firebaseConfiguration, boolean nonPersonalizedAds) {
        this.firebaseConfiguration = firebaseConfiguration;

        this.nonPersonalizedAds = nonPersonalizedAds;
    }

    @Override
    public boolean isLoaded() {
        return GADRewardBasedVideoAd.sharedInstance().isReady();
    }

    @Override
    public void load(String adUnit) {


        GADRequest request = GADRequest.request();

        if (this.nonPersonalizedAds) {
            NSMutableDictionary<NSString, Object> dictionary = (NSMutableDictionary<NSString, Object>) NSMutableDictionary.dictionary();
            dictionary.put(NSString.stringWithString("npa"), NSString.stringWithString("1"));
            GADExtras extras = GADExtras.alloc();
            extras.setAdditionalParameters(dictionary);
            request.registerAdNetworkExtras(extras);
        }





        GADRewardBasedVideoAd.sharedInstance().setDelegate(this);

        if (firebaseConfiguration.admobUseTestDevice) {
//            NSMutableArray nsa = NSMutableArray.alloc().init();
//            nsa.add("4f5c9375d645c9da801af226faede6ea");
//            request.setTestDevices(nsa);
            // adUnit ca-app-pub-3940256099942544/1712485313 for testing
            GADRewardBasedVideoAd.sharedInstance().loadRequestWithAdUnitID(request, "ca-app-pub-3940256099942544/1712485313");
        } else {
            GADRewardBasedVideoAd.sharedInstance().loadRequestWithAdUnitID(request, adUnit);
        }



        controller = ((IOSApplication) Gdx.app).getUIViewController();
    }

    @Override
    public void show() {
        if (isLoaded()) {
            GADRewardBasedVideoAd.sharedInstance().presentFromRootViewController(controller);
        }
    }

    @Override
    public void setRewardVideoAdListener(RewardedVideoAdListener rewardVideoAdListener) {
        this.listener = rewardVideoAdListener;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public void rewardBasedVideoAdDidFailToLoadWithError(GADRewardBasedVideoAd rewardBasedVideoAd, final NSError error) {
        final int code = (int) error.code();
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                switch (code) {
                    case (int) GADErrorCode.NoFill:
                        errorCode = AdmobErrorCode.NO_FILL;
                        break;
                    default:
                        errorCode = AdmobErrorCode.UNKNOWN_OR_NOT_IMPLEMENTED;
                }


                Gdx.app.debug("gdx-firebase", "ADMOB ERROR : FIREBASE SDK ERROR :: " + "(" + errorCode + ")" + error.localizedFailureReason());
                if (listener != null)
                    listener.onRewardedVideoAdFailedToLoad(errorCode);
            }
        });
    }

    @Override
    public void rewardBasedVideoAdDidRewardUserWithReward(GADRewardBasedVideoAd rewardBasedVideoAd, final GADAdReward reward) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (listener != null)
                    listener.onRewarded(new IOSMOERewardItem(reward));
            }
        });
    }

    @Override
    public void rewardBasedVideoAdDidClose(GADRewardBasedVideoAd rewardBasedVideoAd) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {

                if (listener != null)
                    listener.onRewardedVideoAdClosed();
            }
        });

    }

    @Override
    public void rewardBasedVideoAdDidOpen(GADRewardBasedVideoAd rewardBasedVideoAd) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (listener != null)
                    listener.onRewardedVideoAdOpened();
            }
        });
    }

    @Override
    public void rewardBasedVideoAdDidReceiveAd(GADRewardBasedVideoAd rewardBasedVideoAd) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (listener != null)
                    listener.onRewardedVideoAdLoaded();
            }
        });
    }

    @Override
    public void rewardBasedVideoAdDidStartPlaying(GADRewardBasedVideoAd rewardBasedVideoAd) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (listener != null)
                    listener.onRewardedVideoStarted();
            }
        });
    }

    @Override
    public void rewardBasedVideoAdWillLeaveApplication(GADRewardBasedVideoAd rewardBasedVideoAd) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (listener != null)
                    listener.onRewardedVideoAdLeftApplication();
            }
        });
    }
}
