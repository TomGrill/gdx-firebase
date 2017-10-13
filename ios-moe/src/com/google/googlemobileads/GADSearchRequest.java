package com.google.googlemobileads;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import apple.uikit.UIColor;
import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
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
public class GADSearchRequest extends GADRequest {
	static {
		NatJ.register();
	}

	@Generated
	protected GADSearchRequest(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native GADSearchRequest alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("anchorTextColor")
	public native UIColor anchorTextColor();

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("backgroundColor")
	public native UIColor backgroundColor();

	@Generated
	@Selector("borderColor")
	public native UIColor borderColor();

	@Generated
	@Selector("borderThickness")
	@NUInt
	public native long borderThickness();

	@Generated
	@Selector("borderType")
	@NUInt
	public native long borderType();

	@Generated
	@Selector("callButtonColor")
	@NUInt
	public native long callButtonColor();

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
	@Selector("class")
	public static native Class class_objc_static();

	@Generated
	@Selector("classFallbacksForKeyedArchiver")
	public static native NSArray<String> classFallbacksForKeyedArchiver();

	@Generated
	@Selector("classForKeyedUnarchiver")
	public static native Class classForKeyedUnarchiver();

	@Generated
	@Selector("customChannels")
	public native String customChannels();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("descriptionTextColor")
	public native UIColor descriptionTextColor();

	@Generated
	@Selector("fontFamily")
	public native String fontFamily();

	@Generated
	@Selector("gradientFrom")
	public native UIColor gradientFrom();

	@Generated
	@Selector("gradientTo")
	public native UIColor gradientTo();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("headerColor")
	public native UIColor headerColor();

	@Generated
	@Selector("headerTextSize")
	@NUInt
	public native long headerTextSize();

	@Generated
	@Selector("init")
	public native GADSearchRequest init();

	@Generated
	@Selector("initialize")
	public static native void initialize();

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
	@Selector("load")
	public static native void load_objc_static();

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("query")
	public native String query();

	@Generated
	@Selector("request")
	public static native GADSearchRequest request();

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
	@Selector("setAnchorTextColor:")
	public native void setAnchorTextColor(UIColor value);

	@Generated
	@Selector("setBackgroundGradientFrom:toColor:")
	public native void setBackgroundGradientFromToColor(UIColor from,
			UIColor toColor);

	@Generated
	@Selector("setBackgroundSolid:")
	public native void setBackgroundSolid(UIColor color);

	@Generated
	@Selector("setBorderColor:")
	public native void setBorderColor(UIColor value);

	@Generated
	@Selector("setBorderThickness:")
	public native void setBorderThickness(@NUInt long value);

	@Generated
	@Selector("setBorderType:")
	public native void setBorderType(@NUInt long value);

	@Generated
	@Selector("setCallButtonColor:")
	public native void setCallButtonColor(@NUInt long value);

	@Generated
	@Selector("setCustomChannels:")
	public native void setCustomChannels(String value);

	@Generated
	@Selector("setDescriptionTextColor:")
	public native void setDescriptionTextColor(UIColor value);

	@Generated
	@Selector("setFontFamily:")
	public native void setFontFamily(String value);

	@Generated
	@Selector("setHeaderColor:")
	public native void setHeaderColor(UIColor value);

	@Generated
	@Selector("setHeaderTextSize:")
	public native void setHeaderTextSize(@NUInt long value);

	@Generated
	@Selector("setQuery:")
	public native void setQuery(String value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}