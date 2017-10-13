package com.google.googlemobileads.protocol;


import apple.foundation.NSError;
import com.google.googlemobileads.GADAdReward;
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
@ObjCProtocolName("GADMRewardBasedVideoAdNetworkConnector")
public interface GADMRewardBasedVideoAdNetworkConnector extends
		GADMediationAdRequest {
	@Generated
	@Selector("adapter:didFailToLoadRewardBasedVideoAdwithError:")
	void adapterDidFailToLoadRewardBasedVideoAdwithError(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter,
			NSError error);

	@Generated
	@Selector("adapter:didFailToSetUpRewardBasedVideoAdWithError:")
	void adapterDidFailToSetUpRewardBasedVideoAdWithError(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter,
			NSError error);

	@Generated
	@Selector("adapter:didRewardUserWithReward:")
	void adapterDidRewardUserWithReward(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAd,
			GADAdReward reward);

	@Generated
	@Selector("adapterDidCloseRewardBasedVideoAd:")
	void adapterDidCloseRewardBasedVideoAd(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter);

	@Generated
	@Selector("adapterDidGetAdClick:")
	void adapterDidGetAdClick(@Mapped(ObjCObjectMapper.class) Object adapter);

	@Generated
	@Selector("adapterDidOpenRewardBasedVideoAd:")
	void adapterDidOpenRewardBasedVideoAd(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter);

	@Generated
	@Selector("adapterDidReceiveRewardBasedVideoAd:")
	void adapterDidReceiveRewardBasedVideoAd(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter);

	@Generated
	@Selector("adapterDidSetUpRewardBasedVideoAd:")
	void adapterDidSetUpRewardBasedVideoAd(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter);

	@Generated
	@Selector("adapterDidStartPlayingRewardBasedVideoAd:")
	void adapterDidStartPlayingRewardBasedVideoAd(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter);

	@Generated
	@Selector("adapterWillLeaveApplication:")
	void adapterWillLeaveApplication(
			@Mapped(ObjCObjectMapper.class) Object rewardBasedVideoAdAdapter);
}