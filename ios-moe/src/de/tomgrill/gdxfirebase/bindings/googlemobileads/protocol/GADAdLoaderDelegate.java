package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADAdLoader;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADRequestError;
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
@ObjCProtocolName("GADAdLoaderDelegate")
public interface GADAdLoaderDelegate {
	@Generated
	@Selector("adLoader:didFailToReceiveAdWithError:")
	void adLoaderDidFailToReceiveAdWithError(GADAdLoader adLoader,
			GADRequestError error);

	@Generated
	@IsOptional
	@Selector("adLoaderDidFinishLoading:")
	default void adLoaderDidFinishLoading(GADAdLoader adLoader) {
		throw new java.lang.UnsupportedOperationException();
	}
}