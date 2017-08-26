package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


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
@ObjCProtocolName("GADAdDelegate")
public interface GADAdDelegate {
	@Generated
	@IsOptional
	@Selector("ad:shouldChangeAudioSessionToCategory:")
	default boolean adShouldChangeAudioSessionToCategory(
			@Mapped(ObjCObjectMapper.class) Object ad,
			String audioSessionCategory) {
		throw new java.lang.UnsupportedOperationException();
	}
}