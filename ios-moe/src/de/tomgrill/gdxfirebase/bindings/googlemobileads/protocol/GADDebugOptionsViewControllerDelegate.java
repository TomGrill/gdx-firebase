package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADDebugOptionsViewController;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADDebugOptionsViewControllerDelegate")
public interface GADDebugOptionsViewControllerDelegate {
	@Generated
	@Selector("debugOptionsViewControllerDidDismiss:")
	void debugOptionsViewControllerDidDismiss(
			GADDebugOptionsViewController controller);
}