package com.google.googlemobileads.protocol;


import apple.foundation.NSArray;
import apple.uikit.UIViewController;
import com.google.googlemobileads.GADCustomEventRequest;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADCustomEventNativeAd")
public interface GADCustomEventNativeAd {
	@Generated
	@Selector("delegate")
	@MappedReturn(ObjCObjectMapper.class)
	Object delegate();

	@Generated
	@Selector("handlesUserClicks")
	boolean handlesUserClicks();

	@Generated
	@Selector("handlesUserImpressions")
	boolean handlesUserImpressions();

	@Generated
	@Selector("requestNativeAdWithParameter:request:adTypes:options:rootViewController:")
	void requestNativeAdWithParameterRequestAdTypesOptionsRootViewController(
			String serverParameter, GADCustomEventRequest request,
			NSArray<?> adTypes, NSArray<?> options,
			UIViewController rootViewController);

	@Generated
	@Selector("setDelegate:")
	void setDelegate(@Mapped(ObjCObjectMapper.class) Object value);
}