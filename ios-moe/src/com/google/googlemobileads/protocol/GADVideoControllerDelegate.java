package com.google.googlemobileads.protocol;


import com.google.googlemobileads.GADVideoController;
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
@ObjCProtocolName("GADVideoControllerDelegate")
public interface GADVideoControllerDelegate {
	@Generated
	@IsOptional
	@Selector("videoControllerDidEndVideoPlayback:")
	default void videoControllerDidEndVideoPlayback(
			GADVideoController videoController) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("videoControllerDidMuteVideo:")
	default void videoControllerDidMuteVideo(GADVideoController videoController) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("videoControllerDidPauseVideo:")
	default void videoControllerDidPauseVideo(GADVideoController videoController) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("videoControllerDidPlayVideo:")
	default void videoControllerDidPlayVideo(GADVideoController videoController) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("videoControllerDidUnmuteVideo:")
	default void videoControllerDidUnmuteVideo(
			GADVideoController videoController) {
		throw new java.lang.UnsupportedOperationException();
	}
}