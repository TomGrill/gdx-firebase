package de.tomgrill.gdxfirebase.iosmoe.admob;

import apple.foundation.NSMutableArray;
import apple.uikit.UIScreen;
import apple.uikit.UIViewController;
import apple.uikit.UIWindow;
import com.google.googlemobileads.GADInterstitial;
import com.google.googlemobileads.GADRequest;
import com.google.googlemobileads.GADRequestError;
import com.google.googlemobileads.protocol.GADInterstitialDelegate;
import de.tomgrill.gdxfirebase.core.admob.Interstitial;

public class IOSMOEInterstitial implements Interstitial {
    private GADRequest gadRequest;
    private GADInterstitial interstitial;
    private UIViewController uiViewController;
    private UIWindow window;

    IOSMOEInterstitial(String addId)  {

        System.out.println("LOAD");
        gadRequest = GADRequest.alloc();
        NSMutableArray nsa = NSMutableArray.alloc().init();
        nsa.add("4f5c9375d645c9da801af226faede6ea");
        gadRequest.setTestDevices(nsa);


        interstitial = GADInterstitial.alloc().initWithAdUnitID(addId);

        interstitial.setDelegate(new GADInterstitialDelegate() {
            @Override
            public void interstitialDidReceiveAd(GADInterstitial ad) {
                System.out.println("YEAH GOT ADD");
            }

            @Override
            public void interstitialDidFailToReceiveAdWithError(GADInterstitial ad, GADRequestError error) {
                System.out.println(error);
            }
        });

        interstitial.loadRequest(gadRequest);

        if (uiViewController == null) {
            uiViewController = UIViewController.alloc();
        }

        window = UIWindow.alloc();
        window.initWithFrame(UIScreen.mainScreen().bounds());
        window.setRootViewController(uiViewController);
        window.addSubview(uiViewController.view());
    }

    @Override
    public void show() {
        if(!isReady() || hasBeenUsed()) return;
        window.makeKeyAndVisible();
        interstitial.presentFromRootViewController(window.rootViewController());
    }

    @Override
    public boolean isReady() {
        return interstitial.isReady();
    }

    @Override
    public boolean hasBeenUsed() {
        return interstitial.hasBeenUsed();
    }
}
