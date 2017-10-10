package com.google.googlemobileads.protocol;


import apple.NSObject;
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
@ObjCProtocolName("GADCustomEventInterstitialDelegate")
public interface GADCustomEventInterstitialDelegate {
	@Generated
	@Selector("customEventInterstitial:didFailAd:")
	void customEventInterstitialDidFailAd(
            @Mapped(ObjCObjectMapper.class) Object customEvent, NSError error);

	@Generated
	@Deprecated
	@Selector("customEventInterstitial:didReceiveAd:")
	void customEventInterstitialDidReceiveAd(
            @Mapped(ObjCObjectMapper.class) Object customEvent, NSObject ad);

	@Generated
	@Selector("customEventInterstitialDidDismiss:")
	void customEventInterstitialDidDismiss(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventInterstitialDidReceiveAd:")
	void customEventInterstitialDidReceiveAd(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventInterstitialWasClicked:")
	void customEventInterstitialWasClicked(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventInterstitialWillDismiss:")
	void customEventInterstitialWillDismiss(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventInterstitialWillLeaveApplication:")
	void customEventInterstitialWillLeaveApplication(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventInterstitialWillPresent:")
	void customEventInterstitialWillPresent(
            @Mapped(ObjCObjectMapper.class) Object customEvent);
}