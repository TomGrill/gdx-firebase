package com.google.googlemobileads.protocol;


import com.google.googlemobileads.GADCustomEventRequest;
import com.google.googlemobileads.struct.GADAdSize;
import org.moe.natj.general.ann.ByValue;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADCustomEventBanner")
public interface GADCustomEventBanner {
	@Generated
	@Selector("delegate")
	@MappedReturn(ObjCObjectMapper.class)
	Object delegate();

	@Generated
	@Selector("requestBannerAd:parameter:label:request:")
	void requestBannerAdParameterLabelRequest(@ByValue GADAdSize adSize,
			String serverParameter, String serverLabel,
			GADCustomEventRequest request);

	@Generated
	@Selector("setDelegate:")
	void setDelegate(@Mapped(ObjCObjectMapper.class) Object value);
}