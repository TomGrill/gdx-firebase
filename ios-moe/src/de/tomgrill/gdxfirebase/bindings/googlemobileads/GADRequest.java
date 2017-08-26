package de.tomgrill.gdxfirebase.bindings.googlemobileads;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSDate;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import apple.foundation.protocol.NSCopying;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol.GADAdNetworkExtras;
import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.NFloat;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.NUInt;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.Class;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class GADRequest extends NSObject implements NSCopying {
	static {
		NatJ.register();
	}

	@Generated
	protected GADRequest(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Selector("adNetworkExtrasFor:")
	@MappedReturn(ObjCObjectMapper.class)
	public native GADAdNetworkExtras adNetworkExtrasFor(
			@Mapped(ObjCObjectMapper.class) GADAdNetworkExtras aClass);

	@Generated
	@Owned
	@Selector("alloc")
	public static native GADRequest alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("birthday")
	public native NSDate birthday();

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:")
	public static native void cancelPreviousPerformRequestsWithTarget(
			@Mapped(ObjCObjectMapper.class) Object aTarget);

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:selector:object:")
	public static native void cancelPreviousPerformRequestsWithTargetSelectorObject(
			@Mapped(ObjCObjectMapper.class) Object aTarget, SEL aSelector,
			@Mapped(ObjCObjectMapper.class) Object anArgument);

	@Generated
	@Selector("classFallbacksForKeyedArchiver")
	public static native NSArray<String> classFallbacksForKeyedArchiver();

	@Generated
	@Selector("classForKeyedUnarchiver")
	public static native Class classForKeyedUnarchiver();

	@Generated
	@Selector("contentURL")
	public native String contentURL();

	@Generated
	@Owned
	@Selector("copyWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object copyWithZone(VoidPtr zone);

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("gender")
	@NInt
	public native long gender();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native GADRequest init();

	@Generated
	@Selector("instanceMethodForSelector:")
	@FunctionPtr(name = "call_instanceMethodForSelector_ret")
	public static native NSObject.Function_instanceMethodForSelector_ret instanceMethodForSelector(
			SEL aSelector);

	@Generated
	@Selector("instanceMethodSignatureForSelector:")
	public static native NSMethodSignature instanceMethodSignatureForSelector(
			SEL aSelector);

	@Generated
	@Selector("instancesRespondToSelector:")
	public static native boolean instancesRespondToSelector(SEL aSelector);

	@Generated
	@Selector("isSubclassOfClass:")
	public static native boolean isSubclassOfClass(Class aClass);

	@Generated
	@Selector("keyPathsForValuesAffectingValueForKey:")
	public static native NSSet<String> keyPathsForValuesAffectingValueForKey(
			String key);

	@Generated
	@Selector("keywords")
	public native NSArray<?> keywords();

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("registerAdNetworkExtras:")
	public native void registerAdNetworkExtras(
			@Mapped(ObjCObjectMapper.class) GADAdNetworkExtras extras);

	@Generated
	@Selector("removeAdNetworkExtrasFor:")
	public native void removeAdNetworkExtrasFor(
			@Mapped(ObjCObjectMapper.class) GADAdNetworkExtras aClass);

	@Generated
	@Selector("request")
	public static native GADRequest request();

	@Generated
	@Selector("requestAgent")
	public native String requestAgent();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("sdkVersion")
	public static native String sdkVersion();

	@Generated
	@Selector("setBirthday:")
	public native void setBirthday(NSDate value);

	@Generated
	@Deprecated
	@Selector("setBirthdayWithMonth:day:year:")
	public native void setBirthdayWithMonthDayYear(@NInt long month,
			@NInt long day, @NInt long year);

	@Generated
	@Selector("setContentURL:")
	public native void setContentURL(String value);

	@Generated
	@Selector("setGender:")
	public native void setGender(@NInt long value);

	@Generated
	@Selector("setKeywords:")
	public native void setKeywords(NSArray<?> value);

	@Generated
	@Deprecated
	@Selector("setLocationWithDescription:")
	public native void setLocationWithDescription(String locationDescription);

	@Generated
	@Selector("setLocationWithLatitude:longitude:accuracy:")
	public native void setLocationWithLatitudeLongitudeAccuracy(
			@NFloat double latitude, @NFloat double longitude,
			@NFloat double accuracyInMeters);

	@Generated
	@Selector("setRequestAgent:")
	public native void setRequestAgent(String value);

	@Generated
	@Selector("setTestDevices:")
	public native void setTestDevices(NSArray<?> value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("tagForChildDirectedTreatment:")
	public native void tagForChildDirectedTreatment(
			boolean childDirectedTreatment);

	@Generated
	@Selector("testDevices")
	public native NSArray<?> testDevices();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}