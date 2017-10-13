package com.google.googlemobileads.protocol;


import com.google.googlemobileads.GADInterstitial;
import com.google.googlemobileads.GADRequestError;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADInterstitialDelegate")
public interface GADInterstitialDelegate {
	@Generated
	@IsOptional
	@Selector("interstitial:didFailToReceiveAdWithError:")
	default void interstitialDidFailToReceiveAdWithError(GADInterstitial ad,
			GADRequestError error) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("interstitialDidDismissScreen:")
	default void interstitialDidDismissScreen(GADInterstitial ad) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("interstitialDidFailToPresentScreen:")
	default void interstitialDidFailToPresentScreen(GADInterstitial ad) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("interstitialDidReceiveAd:")
	default void interstitialDidReceiveAd(GADInterstitial ad) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("interstitialWillDismissScreen:")
	default void interstitialWillDismissScreen(GADInterstitial ad) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("interstitialWillLeaveApplication:")
	default void interstitialWillLeaveApplication(GADInterstitial ad) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("interstitialWillPresentScreen:")
	default void interstitialWillPresentScreen(GADInterstitial ad) {
		throw new java.lang.UnsupportedOperationException();
	}
}