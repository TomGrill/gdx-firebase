package de.tomgrill.gdxfirebase.iosmoe.admob;

import apple.foundation.NSError;
import apple.foundation.NSMutableArray;
import apple.uikit.UIDevice;
import apple.uikit.UIScreen;
import apple.uikit.UIViewController;
import apple.uikit.UIWindow;
import com.badlogic.gdx.Gdx;
import com.google.googlemobileads.GADAdReward;
import com.google.googlemobileads.GADRequest;
import com.google.googlemobileads.GADRewardBasedVideoAd;
import com.google.googlemobileads.enums.GADErrorCode;
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

    private GADRequest request;
    private UIWindow windows;

    private GADRewardBasedVideoAd gadRewardBasedVideoAd;

    private volatile int errorCode = 0;

    public IOSMOEVideoRewardAd(FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;

        gadRewardBasedVideoAd = GADRewardBasedVideoAd.sharedInstance();
    }

    private String getDeviceUUID() {
        System.out.println("WARN HARDCODED DEVICE ID, need AUTO RETRIEVE");
        return "4f5c9375d645c9da801af226faede6ea";
    }

    @Override
    public boolean isLoaded() {

        //System.out.println("H " + GADRewardBasedVideoAd.sharedInstance().isReady());
        return gadRewardBasedVideoAd.isReady();
    }

    @Override
    public void load(String adUnit) {


        request = GADRequest.request();

        if (firebaseConfiguration.admobUseTestDevice) {
            NSMutableArray nsMutableArray = NSMutableArray.array();
            //nsMutableArray.add(UIDevice.currentDevice().identifierForVendor().UUIDString());
            nsMutableArray.add(getDeviceUUID());
            System.out.println("ADMOB DEVICE UUIDString" + UIDevice.currentDevice().identifierForVendor().UUIDString());


            request.setTestDevices(nsMutableArray);

        }
        gadRewardBasedVideoAd.setDelegate(this);
        gadRewardBasedVideoAd.loadRequestWithAdUnitID(request, adUnit);
        //ca-app-pub-3940256099942544/1712485313

        controller = UIViewController.alloc();
        windows = UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
        windows.setRootViewController(controller);
        windows.addSubview(controller.view());
    }

    @Override
    public void show() {
        if (isLoaded()) {
            windows.makeKeyAndVisible();
            gadRewardBasedVideoAd.presentFromRootViewController(controller);
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
    public void rewardBasedVideoAdDidFailToLoadWithError(GADRewardBasedVideoAd rewardBasedVideoAd, NSError error) {
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
    @Selector("rewardBasedVideoAdDidRewardUserWithReward:")
    public void rewardBasedVideoAdDidRewardUserWithReward(GADRewardBasedVideoAd rewardBasedVideoAd, GADAdReward reward) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (listener != null)
                    listener.onRewarded(new IOSMOERewardItem(reward));
            }
        });
    }

    @Override
    @Selector("rewardBasedVideoAdDidClose:")
    public void rewardBasedVideoAdDidClose(GADRewardBasedVideoAd rewardBasedVideoAd) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                windows.setHidden(true);
                if (listener != null)
                    listener.onRewardedVideoAdClosed();
            }
        });

    }

    @Override
    @Selector("rewardBasedVideoAdDidOpen:")
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
