package com.google.googlemobileads.protocol;


import apple.foundation.NSArray;
import apple.foundation.NSDictionary;
import apple.uikit.UIViewController;
import org.moe.natj.general.ann.*;
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
@ObjCProtocolName("GADMRewardBasedVideoAdNetworkAdapter")
public interface GADMRewardBasedVideoAdNetworkAdapter {
	@Generated
	@Selector("adapterVersion")
	@ProtocolClassMethod("adapterVersion")
	String _adapterVersion();

	@Generated
	@IsOptional
	@Deprecated
	@Selector("initWithGADMAdNetworkConnector:")
	@MappedReturn(ObjCObjectMapper.class)
	default Object initWithGADMAdNetworkConnector(
            @Mapped(ObjCObjectMapper.class) Object connector) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@Selector("initWithRewardBasedVideoAdNetworkConnector:")
	@MappedReturn(ObjCObjectMapper.class)
	Object initWithRewardBasedVideoAdNetworkConnector(
            @Mapped(ObjCObjectMapper.class) Object connector);

	@Generated
	@IsOptional
	@Selector("initWithRewardBasedVideoAdNetworkConnector:credentials:")
	@MappedReturn(ObjCObjectMapper.class)
	default Object initWithRewardBasedVideoAdNetworkConnectorCredentials(
            @Mapped(ObjCObjectMapper.class) Object connector,
            NSArray<? extends NSDictionary<?, ?>> credentials) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@Selector("networkExtrasClass")
	@ProtocolClassMethod("networkExtrasClass")
	@MappedReturn(ObjCObjectMapper.class)
	Object _networkExtrasClass();

	@Generated
	@Selector("presentRewardBasedVideoAdWithRootViewController:")
	void presentRewardBasedVideoAdWithRootViewController(
            UIViewController viewController);

	@Generated
	@Selector("requestRewardBasedVideoAd")
	void requestRewardBasedVideoAd();

	@Generated
	@Selector("setUp")
	void setUp();

	@Generated
	@IsOptional
	@Deprecated
	@Selector("setUpWithUserID:")
	default void setUpWithUserID(String userID) {
		throw new UnsupportedOperationException();
	}

	@Generated
	@Selector("stopBeingDelegate")
	void stopBeingDelegate();
}