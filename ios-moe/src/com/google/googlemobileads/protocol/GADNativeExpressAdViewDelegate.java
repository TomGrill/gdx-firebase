package com.google.googlemobileads.protocol;


import com.google.googlemobileads.GADNativeExpressAdView;
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
@ObjCProtocolName("GADNativeExpressAdViewDelegate")
public interface GADNativeExpressAdViewDelegate {
	@Generated
	@IsOptional
	@Selector("nativeExpressAdView:didFailToReceiveAdWithError:")
	default void nativeExpressAdViewDidFailToReceiveAdWithError(
            GADNativeExpressAdView nativeExpressAdView, GADRequestError error) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeExpressAdViewDidDismissScreen:")
	default void nativeExpressAdViewDidDismissScreen(
            GADNativeExpressAdView nativeExpressAdView) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeExpressAdViewDidReceiveAd:")
	default void nativeExpressAdViewDidReceiveAd(
            GADNativeExpressAdView nativeExpressAdView) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeExpressAdViewWillDismissScreen:")
	default void nativeExpressAdViewWillDismissScreen(
            GADNativeExpressAdView nativeExpressAdView) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeExpressAdViewWillLeaveApplication:")
	default void nativeExpressAdViewWillLeaveApplication(
            GADNativeExpressAdView nativeExpressAdView) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeExpressAdViewWillPresentScreen:")
	default void nativeExpressAdViewWillPresentScreen(
            GADNativeExpressAdView nativeExpressAdView) {
		throw new UnsupportedOperationException();
	}
}