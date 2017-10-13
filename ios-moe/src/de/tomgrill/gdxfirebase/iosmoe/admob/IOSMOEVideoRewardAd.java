package de.tomgrill.gdxfirebase.iosmoe.admob;

import apple.foundation.NSError;
import apple.foundation.NSMutableArray;
import apple.uikit.UIDevice;
import apple.uikit.UIScreen;
import apple.uikit.UIViewController;
import apple.uikit.UIWindow;
import com.google.googlemobileads.GADAdReward;
import com.google.googlemobileads.GADRequest;
import com.google.googlemobileads.GADRewardBasedVideoAd;
import com.google.googlemobileads.protocol.GADRewardBasedVideoAdDelegate;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.admob.RewardedVideoAdListener;
import de.tomgrill.gdxfirebase.core.admob.VideoRewardAd;
import org.moe.natj.objc.ann.Selector;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IOSMOEVideoRewardAd implements VideoRewardAd, GADRewardBasedVideoAdDelegate {

    private RewardedVideoAdListener listener;

    private UIViewController controller;

    private FirebaseConfiguration firebaseConfiguration;

    private GADRequest request;
    private UIWindow windows;

    private GADRewardBasedVideoAd gadRewardBasedVideoAd;

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

        if(firebaseConfiguration.admobUseTestDevice) {
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
        if(isLoaded()) {
            windows.makeKeyAndVisible();
            gadRewardBasedVideoAd.presentFromRootViewController(controller);
        }
    }

    @Override
    public void setRewardVideoAdListener(RewardedVideoAdListener rewardVideoAdListener) {
        this.listener = rewardVideoAdListener;
    }

    @Override
    public void rewardBasedVideoAdDidFailToLoadWithError(GADRewardBasedVideoAd rewardBasedVideoAd, NSError error) {
        if (listener != null)
            listener.onRewardedVideoAdFailedToLoad((int) error.code());
    }

    @Override
    @Selector("rewardBasedVideoAdDidRewardUserWithReward:")
    public void rewardBasedVideoAdDidRewardUserWithReward(GADRewardBasedVideoAd rewardBasedVideoAd, GADAdReward reward) {
        if (listener != null)
            listener.onRewarded(new IOSMOERewardItem(reward));
    }

    @Override
    @Selector("rewardBasedVideoAdDidClose:")
    public void rewardBasedVideoAdDidClose(GADRewardBasedVideoAd rewardBasedVideoAd) {
        windows.setHidden(true);
        if (listener != null)
            listener.onRewardedVideoAdClosed();

    }

    @Override
    @Selector("rewardBasedVideoAdDidOpen:")
    public void rewardBasedVideoAdDidOpen(GADRewardBasedVideoAd rewardBasedVideoAd) {
        if (listener != null)
            listener.onRewardedVideoAdOpened();
    }

    @Override
    public void rewardBasedVideoAdDidReceiveAd(GADRewardBasedVideoAd rewardBasedVideoAd) {
        if (listener != null)
            listener.onRewardedVideoAdLoaded();
    }

    @Override
    public void rewardBasedVideoAdDidStartPlaying(GADRewardBasedVideoAd rewardBasedVideoAd) {
        if (listener != null)
            listener.onRewardedVideoStarted();
    }

    @Override
    public void rewardBasedVideoAdWillLeaveApplication(GADRewardBasedVideoAd rewardBasedVideoAd) {
        if (listener != null)
            listener.onRewardedVideoAdLeftApplication();
    }
}
