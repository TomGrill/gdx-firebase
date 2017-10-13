package com.google.googlemobileads.protocol;


import com.google.googlemobileads.DFPBannerView;
import com.google.googlemobileads.DFPCustomRenderedAd;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("DFPCustomRenderedBannerViewDelegate")
public interface DFPCustomRenderedBannerViewDelegate {
	@Generated
	@Selector("bannerView:didReceiveCustomRenderedAd:")
	void bannerViewDidReceiveCustomRenderedAd(DFPBannerView bannerView,
			DFPCustomRenderedAd customRenderedAd);
}