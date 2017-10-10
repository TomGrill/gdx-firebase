package com.google.googlemobileads.protocol;


import apple.foundation.NSError;
import apple.uikit.UIView;
import apple.uikit.UIViewController;
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
@ObjCProtocolName("GADCustomEventBannerDelegate")
public interface GADCustomEventBannerDelegate {
	@Generated
	@Deprecated
	@Selector("customEventBanner:clickDidOccurInAd:")
	void customEventBannerClickDidOccurInAd(
            @Mapped(ObjCObjectMapper.class) Object customEvent, UIView view);

	@Generated
	@Selector("customEventBanner:didFailAd:")
	void customEventBannerDidFailAd(
            @Mapped(ObjCObjectMapper.class) Object customEvent, NSError error);

	@Generated
	@Selector("customEventBanner:didReceiveAd:")
	void customEventBannerDidReceiveAd(
            @Mapped(ObjCObjectMapper.class) Object customEvent, UIView view);

	@Generated
	@Selector("customEventBannerDidDismissModal:")
	void customEventBannerDidDismissModal(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventBannerWasClicked:")
	void customEventBannerWasClicked(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventBannerWillDismissModal:")
	void customEventBannerWillDismissModal(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventBannerWillLeaveApplication:")
	void customEventBannerWillLeaveApplication(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("customEventBannerWillPresentModal:")
	void customEventBannerWillPresentModal(
            @Mapped(ObjCObjectMapper.class) Object customEvent);

	@Generated
	@Selector("viewControllerForPresentingModalView")
	UIViewController viewControllerForPresentingModalView();
}