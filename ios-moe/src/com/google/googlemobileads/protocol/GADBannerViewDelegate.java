package com.google.googlemobileads.protocol;


import com.google.googlemobileads.GADBannerView;
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
@ObjCProtocolName("GADBannerViewDelegate")
public interface GADBannerViewDelegate {
	@Generated
	@IsOptional
	@Selector("adView:didFailToReceiveAdWithError:")
	default void adViewDidFailToReceiveAdWithError(GADBannerView bannerView,
			GADRequestError error) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("adViewDidDismissScreen:")
	default void adViewDidDismissScreen(GADBannerView bannerView) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("adViewDidReceiveAd:")
	default void adViewDidReceiveAd(GADBannerView bannerView) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("adViewWillDismissScreen:")
	default void adViewWillDismissScreen(GADBannerView bannerView) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("adViewWillLeaveApplication:")
	default void adViewWillLeaveApplication(GADBannerView bannerView) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("adViewWillPresentScreen:")
	default void adViewWillPresentScreen(GADBannerView bannerView) {
		throw new java.lang.UnsupportedOperationException();
	}
}