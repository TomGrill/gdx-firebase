package com.google.googlemobileads.protocol;


import com.google.googlemobileads.GADDefaultInAppPurchase;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADDefaultInAppPurchaseDelegate")
public interface GADDefaultInAppPurchaseDelegate {
	@Generated
	@IsOptional
	@Selector("shouldStartPurchaseForProductID:quantity:")
	default boolean shouldStartPurchaseForProductIDQuantity(String productID,
			@NInt long quantity) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@Selector("userDidPayForPurchase:")
	void userDidPayForPurchase(GADDefaultInAppPurchase defaultInAppPurchase);
}