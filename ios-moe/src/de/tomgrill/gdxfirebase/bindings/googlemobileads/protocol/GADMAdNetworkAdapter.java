package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import apple.foundation.NSArray;
import apple.uikit.UIViewController;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.struct.GADAdSize;
import org.moe.natj.general.ann.ByValue;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.ProtocolClassMethod;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADMAdNetworkAdapter")
public interface GADMAdNetworkAdapter {
	@Generated
	@Selector("adapterVersion")
	@ProtocolClassMethod("adapterVersion")
	String _adapterVersion();

	@Generated
	@IsOptional
	@Selector("changeAdSizeTo:")
	default void changeAdSizeTo(@ByValue GADAdSize adSize) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@Selector("getBannerWithSize:")
	void getBannerWithSize(@ByValue GADAdSize adSize);

	@Generated
	@Selector("getInterstitial")
	void getInterstitial();

	@Generated
	@IsOptional
	@Selector("getNativeAdWithAdTypes:options:")
	default void getNativeAdWithAdTypesOptions(NSArray<?> adTypes,
			NSArray<?> options) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("handlesUserClicks")
	default boolean handlesUserClicks() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("handlesUserImpressions")
	default boolean handlesUserImpressions() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@Selector("initWithGADMAdNetworkConnector:")
	@MappedReturn(ObjCObjectMapper.class)
	Object initWithGADMAdNetworkConnector(
			@Mapped(ObjCObjectMapper.class) Object connector);

	@Generated
	@Selector("isBannerAnimationOK:")
	boolean isBannerAnimationOK(@NInt long animType);

	@Generated
	@Selector("networkExtrasClass")
	@ProtocolClassMethod("networkExtrasClass")
	@MappedReturn(ObjCObjectMapper.class)
	Object _networkExtrasClass();

	@Generated
	@Selector("presentInterstitialFromRootViewController:")
	void presentInterstitialFromRootViewController(
			UIViewController rootViewController);

	@Generated
	@Selector("stopBeingDelegate")
	void stopBeingDelegate();
}