package com.google.googlemobileads.protocol;


import apple.foundation.NSDictionary;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADMediatedNativeAd")
public interface GADMediatedNativeAd {
	@Generated
	@Selector("extraAssets")
	NSDictionary<?, ?> extraAssets();

	@Generated
	@Selector("mediatedNativeAdDelegate")
	@MappedReturn(ObjCObjectMapper.class)
	Object mediatedNativeAdDelegate();
}