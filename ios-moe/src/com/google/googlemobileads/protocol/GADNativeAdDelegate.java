package com.google.googlemobileads.protocol;


import com.google.googlemobileads.GADNativeAd;
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
@ObjCProtocolName("GADNativeAdDelegate")
public interface GADNativeAdDelegate {
	@Generated
	@IsOptional
	@Selector("nativeAdDidDismissScreen:")
	default void nativeAdDidDismissScreen(GADNativeAd nativeAd) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeAdDidRecordClick:")
	default void nativeAdDidRecordClick(GADNativeAd nativeAd) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeAdDidRecordImpression:")
	default void nativeAdDidRecordImpression(GADNativeAd nativeAd) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeAdWillDismissScreen:")
	default void nativeAdWillDismissScreen(GADNativeAd nativeAd) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeAdWillLeaveApplication:")
	default void nativeAdWillLeaveApplication(GADNativeAd nativeAd) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("nativeAdWillPresentScreen:")
	default void nativeAdWillPresentScreen(GADNativeAd nativeAd) {
		throw new UnsupportedOperationException();
	}
}