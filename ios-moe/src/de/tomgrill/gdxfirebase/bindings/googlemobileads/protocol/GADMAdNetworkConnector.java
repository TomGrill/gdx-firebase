package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import apple.NSObject;
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
@ObjCProtocolName("GADMAdNetworkConnector")
public interface GADMAdNetworkConnector extends GADMediationAdRequest {
	@Generated
	@Selector("adMuted")
	boolean adMuted();

	@Generated
	@Selector("adVolume")
	float adVolume();

	@Generated
	@Deprecated
	@Selector("adapter:clickDidOccurInBanner:")
	void adapterClickDidOccurInBanner(
			@Mapped(ObjCObjectMapper.class) Object adapter, UIView view);

	@Generated
	@Selector("adapter:didFailAd:")
	void adapterDidFailAd(@Mapped(ObjCObjectMapper.class) Object adapter,
			NSError error);

	@Generated
	@Deprecated
	@Selector("adapter:didFailInterstitial:")
	void adapterDidFailInterstitial(
			@Mapped(ObjCObjectMapper.class) Object adapter, NSError error);

	@Generated
	@Selector("adapter:didReceiveAdView:")
	void adapterDidReceiveAdView(
			@Mapped(ObjCObjectMapper.class) Object adapter, UIView view);

	@Generated
	@Deprecated
	@Selector("adapter:didReceiveInterstitial:")
	void adapterDidReceiveInterstitial(
			@Mapped(ObjCObjectMapper.class) Object adapter,
			NSObject interstitial);

	@Generated
	@Selector("adapter:didReceiveMediatedNativeAd:")
	void adapterDidReceiveMediatedNativeAd(
			@Mapped(ObjCObjectMapper.class) Object adapter,
			@Mapped(ObjCObjectMapper.class) Object mediatedNativeAd);

	@Generated
	@Selector("adapterDidDismissFullScreenModal:")
	void adapterDidDismissFullScreenModal(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterDidDismissInterstitial:")
	void adapterDidDismissInterstitial(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterDidGetAdClick:")
	void adapterDidGetAdClick(@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterDidReceiveInterstitial:")
	void adapterDidReceiveInterstitial(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterWillDismissFullScreenModal:")
	void adapterWillDismissFullScreenModal(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterWillDismissInterstitial:")
	void adapterWillDismissInterstitial(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterWillLeaveApplication:")
	void adapterWillLeaveApplication(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterWillPresentFullScreenModal:")
	void adapterWillPresentFullScreenModal(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterWillPresentInterstitial:")
	void adapterWillPresentInterstitial(
			@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("viewControllerForPresentingModalView")
	UIViewController viewControllerForPresentingModalView();
}