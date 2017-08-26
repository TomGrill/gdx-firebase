package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADAudioVideoManager;
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
@ObjCProtocolName("GADAudioVideoManagerDelegate")
public interface GADAudioVideoManagerDelegate {
	@Generated
	@IsOptional
	@Selector("audioVideoManagerDidPauseAllVideo:")
	default void audioVideoManagerDidPauseAllVideo(
			GADAudioVideoManager audioVideoManager) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("audioVideoManagerDidStopPlayingAudio:")
	default void audioVideoManagerDidStopPlayingAudio(
			GADAudioVideoManager audioVideoManager) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("audioVideoManagerWillPlayAudio:")
	default void audioVideoManagerWillPlayAudio(
			GADAudioVideoManager audioVideoManager) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("audioVideoManagerWillPlayVideo:")
	default void audioVideoManagerWillPlayVideo(
			GADAudioVideoManager audioVideoManager) {
		throw new java.lang.UnsupportedOperationException();
	}
}