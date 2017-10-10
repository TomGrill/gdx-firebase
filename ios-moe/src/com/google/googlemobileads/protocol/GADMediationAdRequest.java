package com.google.googlemobileads.protocol;


import apple.foundation.NSArray;
import apple.foundation.NSDate;
import apple.foundation.NSDictionary;
import apple.foundation.NSNumber;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADMediationAdRequest")
public interface GADMediationAdRequest {
	@Generated
	@Selector("childDirectedTreatment")
	NSNumber childDirectedTreatment();

	@Generated
	@Selector("credentials")
	NSDictionary<?, ?> credentials();

	@Generated
	@Selector("networkExtras")
	@MappedReturn(ObjCObjectMapper.class)
	Object networkExtras();

	@Generated
	@Selector("publisherId")
	String publisherId();

	@Generated
	@Selector("testMode")
	boolean testMode();

	@Generated
	@Selector("userBirthday")
	NSDate userBirthday();

	@Generated
	@Selector("userGender")
	@NInt
	long userGender();

	@Generated
	@Selector("userHasLocation")
	boolean userHasLocation();

	@Generated
	@Selector("userKeywords")
	NSArray<?> userKeywords();

	@Generated
	@Selector("userLatitude")
	@NFloat
	double userLatitude();

	@Generated
	@Selector("userLocationAccuracyInMeters")
	@NFloat
	double userLocationAccuracyInMeters();

	@Generated
	@Selector("userLocationDescription")
	String userLocationDescription();

	@Generated
	@Selector("userLongitude")
	@NFloat
	double userLongitude();
}