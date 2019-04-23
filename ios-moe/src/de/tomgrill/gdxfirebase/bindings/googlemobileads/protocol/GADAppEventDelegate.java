package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADBannerView;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADInterstitial;
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
@ObjCProtocolName("GADAppEventDelegate")
public interface GADAppEventDelegate {
	@Generated
	@IsOptional
	@Selector("adView:didReceiveAppEvent:withInfo:")
	default void adViewDidReceiveAppEventWithInfo(GADBannerView banner,
			String name, String info) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("interstitial:didReceiveAppEvent:withInfo:")
	default void interstitialDidReceiveAppEventWithInfo(
			GADInterstitial interstitial, String name, String info) {
		throw new java.lang.UnsupportedOperationException();
	}
}