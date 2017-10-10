package com.google.googlemobileads.protocol;


import apple.uikit.UIViewController;
import com.google.googlemobileads.GADCustomEventRequest;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADCustomEventInterstitial")
public interface GADCustomEventInterstitial {
	@Generated
	@Selector("delegate")
	@MappedReturn(ObjCObjectMapper.class)
	Object delegate();

	@Generated
	@Selector("presentFromRootViewController:")
	void presentFromRootViewController(UIViewController rootViewController);

	@Generated
	@Selector("requestInterstitialAdWithParameter:label:request:")
	void requestInterstitialAdWithParameterLabelRequest(String serverParameter,
                                                        String serverLabel, GADCustomEventRequest request);

	@Generated
	@Selector("setDelegate:")
	void setDelegate(@Mapped(ObjCObjectMapper.class) Object value);
}