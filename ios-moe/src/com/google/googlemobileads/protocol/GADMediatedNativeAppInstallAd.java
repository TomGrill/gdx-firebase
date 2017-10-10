package com.google.googlemobileads.protocol;


import apple.foundation.NSArray;
import apple.foundation.NSDecimalNumber;
import apple.uikit.UIView;
import com.google.googlemobileads.GADNativeAdImage;
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
@ObjCProtocolName("GADMediatedNativeAppInstallAd")
public interface GADMediatedNativeAppInstallAd extends GADMediatedNativeAd {
	@Generated
	@IsOptional
	@Selector("adChoicesView")
	default UIView adChoicesView() {
		throw new UnsupportedOperationException();
	}

	@Generated
	@Selector("body")
	String body();

	@Generated
	@Selector("callToAction")
	String callToAction();

	@Generated
	@Selector("headline")
	String headline();

	@Generated
	@Selector("icon")
    GADNativeAdImage icon();

	@Generated
	@Selector("images")
	NSArray<?> images();

	@Generated
	@Selector("price")
	String price();

	@Generated
	@Selector("starRating")
	NSDecimalNumber starRating();

	@Generated
	@Selector("store")
	String store();
}