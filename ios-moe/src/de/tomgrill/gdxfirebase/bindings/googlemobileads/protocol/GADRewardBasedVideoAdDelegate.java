package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import apple.foundation.NSError;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADAdReward;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADRewardBasedVideoAd;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADRewardBasedVideoAdDelegate")
public interface GADRewardBasedVideoAdDelegate {
	@Generated
	@IsOptional
	@Selector("rewardBasedVideoAd:didFailToLoadWithError:")
	default void rewardBasedVideoAdDidFailToLoadWithError(
			GADRewardBasedVideoAd rewardBasedVideoAd, NSError error) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@Selector("rewardBasedVideoAd:didRewardUserWithReward:")
	void rewardBasedVideoAdDidRewardUserWithReward(
			GADRewardBasedVideoAd rewardBasedVideoAd, GADAdReward reward);

	@Generated
	@IsOptional
	@Selector("rewardBasedVideoAdDidClose:")
	default void rewardBasedVideoAdDidClose(
			GADRewardBasedVideoAd rewardBasedVideoAd) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("rewardBasedVideoAdDidOpen:")
	default void rewardBasedVideoAdDidOpen(
			GADRewardBasedVideoAd rewardBasedVideoAd) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("rewardBasedVideoAdDidReceiveAd:")
	default void rewardBasedVideoAdDidReceiveAd(
			GADRewardBasedVideoAd rewardBasedVideoAd) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("rewardBasedVideoAdDidStartPlaying:")
	default void rewardBasedVideoAdDidStartPlaying(
			GADRewardBasedVideoAd rewardBasedVideoAd) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("rewardBasedVideoAdWillLeaveApplication:")
	default void rewardBasedVideoAdWillLeaveApplication(
			GADRewardBasedVideoAd rewardBasedVideoAd) {
		throw new java.lang.UnsupportedOperationException();
	}
}