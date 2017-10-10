package com.google.googlemobileads.protocol;


import apple.foundation.NSError;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADCustomEventNativeAdDelegate")
public interface GADCustomEventNativeAdDelegate {
	@Generated
	@Selector("customEventNativeAd:didFailToLoadWithError:")
	void customEventNativeAdDidFailToLoadWithError(
            @Mapped(ObjCObjectMapper.class) Object customEventNativeAd,
            NSError error);

	@Generated
	@Selector("customEventNativeAd:didReceiveMediatedNativeAd:")
	void customEventNativeAdDidReceiveMediatedNativeAd(
            @Mapped(ObjCObjectMapper.class) Object customEventNativeAd,
            @Mapped(ObjCObjectMapper.class) Object mediatedNativeAd);
}