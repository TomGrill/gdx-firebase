package com.google.googlemobileads.protocol;


import apple.uikit.UIView;
import apple.uikit.UIViewController;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADMediatedNativeAdDelegate")
public interface GADMediatedNativeAdDelegate {
	@Generated
	@IsOptional
	@Selector("mediatedNativeAd:didRecordClickOnAssetWithName:view:viewController:")
	default void mediatedNativeAdDidRecordClickOnAssetWithNameViewViewController(
			@Mapped(ObjCObjectMapper.class) Object mediatedNativeAd,
			String assetName, UIView view, UIViewController viewController) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("mediatedNativeAd:didRenderInView:viewController:")
	default void mediatedNativeAdDidRenderInViewViewController(
			@Mapped(ObjCObjectMapper.class) Object mediatedNativeAd,
			UIView view, UIViewController viewController) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("mediatedNativeAd:didUntrackView:")
	default void mediatedNativeAdDidUntrackView(
			@Mapped(ObjCObjectMapper.class) Object mediatedNativeAd, UIView view) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("mediatedNativeAdDidRecordImpression:")
	default void mediatedNativeAdDidRecordImpression(
			@Mapped(ObjCObjectMapper.class) Object mediatedNativeAd) {
		throw new java.lang.UnsupportedOperationException();
	}
}