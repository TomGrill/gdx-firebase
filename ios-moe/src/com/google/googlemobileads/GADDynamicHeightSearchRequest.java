package com.google.googlemobileads;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.*;
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
public class GADDynamicHeightSearchRequest extends GADRequest {
	static {
		NatJ.register();
	}

	@Generated
	protected GADDynamicHeightSearchRequest(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("CSSWidth")
	public native String CSSWidth();

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Selector("adBorderCSSSelections")
	public native String adBorderCSSSelections();

	@Generated
	@Selector("adBorderColor")
	public native String adBorderColor();

	@Generated
	@Selector("adPage")
	@NInt
	public native long adPage();

	@Generated
	@Selector("adSeparatorColor")
	public native String adSeparatorColor();

	@Generated
	@Selector("adTestEnabled")
	public native boolean adTestEnabled();

	@Generated
	@Selector("adjustableLineHeight")
	@NFloat
	public native double adjustableLineHeight();

	@Generated
	@Owned
	@Selector("alloc")
	public static native GADDynamicHeightSearchRequest alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("annotationFontSize")
	@NFloat
	public native double annotationFontSize();

	@Generated
	@Selector("annotationTextColor")
	public native String annotationTextColor();

	@Generated
	@Selector("attributionBottomSpacing")
	@NFloat
	public native double attributionBottomSpacing();

	@Generated
	@Selector("attributionFontFamily")
	public native String attributionFontFamily();

	@Generated
	@Selector("attributionFontSize")
	@NFloat
	public native double attributionFontSize();

	@Generated
	@Selector("attributionTextColor")
	public native String attributionTextColor();

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("backgroundColor")
	public native String backgroundColor();

	@Generated
	@Selector("boldTitleEnabled")
	public native boolean boldTitleEnabled();

	@Generated
	@Selector("borderCSSSelections")
	public native String borderCSSSelections();

	@Generated
	@Selector("borderColor")
	public native String borderColor();

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
	@Selector("channel")
	public native String channel();

	@Generated
	@Selector("classFallbacksForKeyedArchiver")
	public static native NSArray<String> classFallbacksForKeyedArchiver();

	@Generated
	@Selector("classForKeyedUnarchiver")
	public static native Class classForKeyedUnarchiver();

	@Generated
	@Selector("clickToCallExtensionEnabled")
	public native boolean clickToCallExtensionEnabled();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("descriptionFontSize")
	@NFloat
	public native double descriptionFontSize();

	@Generated
	@Selector("detailedAttributionExtensionEnabled")
	public native boolean detailedAttributionExtensionEnabled();

	@Generated
	@Selector("domainLinkColor")
	public native String domainLinkColor();

	@Generated
	@Selector("domainLinkFontSize")
	@NFloat
	public native double domainLinkFontSize();

	@Generated
	@Selector("fontFamily")
	public native String fontFamily();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("hostLanguage")
	public native String hostLanguage();

	@Generated
	@Selector("init")
	public native GADDynamicHeightSearchRequest init();

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
	@Selector("locationExtensionEnabled")
	public native boolean locationExtensionEnabled();

	@Generated
	@Selector("locationExtensionFontSize")
	@NFloat
	public native double locationExtensionFontSize();

	@Generated
	@Selector("locationExtensionTextColor")
	public native String locationExtensionTextColor();

	@Generated
	@Selector("longerHeadlinesExtensionEnabled")
	public native boolean longerHeadlinesExtensionEnabled();

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("numberOfAds")
	@NInt
	public native long numberOfAds();

	@Generated
	@Selector("plusOnesExtensionEnabled")
	public native boolean plusOnesExtensionEnabled();

	@Generated
	@Selector("query")
	public native String query();

	@Generated
	@Selector("request")
	public static native GADDynamicHeightSearchRequest request();

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
	@Selector("sellerRatingsExtensionEnabled")
	public native boolean sellerRatingsExtensionEnabled();

	@Generated
	@Selector("setAdBorderCSSSelections:")
	public native void setAdBorderCSSSelections(String value);

	@Generated
	@Selector("setAdBorderColor:")
	public native void setAdBorderColor(String value);

	@Generated
	@Selector("setAdPage:")
	public native void setAdPage(@NInt long value);

	@Generated
	@Selector("setAdSeparatorColor:")
	public native void setAdSeparatorColor(String value);

	@Generated
	@Selector("setAdTestEnabled:")
	public native void setAdTestEnabled(boolean value);

	@Generated
	@Selector("setAdjustableLineHeight:")
	public native void setAdjustableLineHeight(@NFloat double value);

	@Generated
	@Selector("setAdvancedOptionValue:forKey:")
	public native void setAdvancedOptionValueForKey(
			@Mapped(ObjCObjectMapper.class) Object value, String key);

	@Generated
	@Selector("setAnnotationFontSize:")
	public native void setAnnotationFontSize(@NFloat double value);

	@Generated
	@Selector("setAnnotationTextColor:")
	public native void setAnnotationTextColor(String value);

	@Generated
	@Selector("setAttributionBottomSpacing:")
	public native void setAttributionBottomSpacing(@NFloat double value);

	@Generated
	@Selector("setAttributionFontFamily:")
	public native void setAttributionFontFamily(String value);

	@Generated
	@Selector("setAttributionFontSize:")
	public native void setAttributionFontSize(@NFloat double value);

	@Generated
	@Selector("setAttributionTextColor:")
	public native void setAttributionTextColor(String value);

	@Generated
	@Selector("setBackgroundColor:")
	public native void setBackgroundColor(String value);

	@Generated
	@Selector("setBoldTitleEnabled:")
	public native void setBoldTitleEnabled(boolean value);

	@Generated
	@Selector("setBorderCSSSelections:")
	public native void setBorderCSSSelections(String value);

	@Generated
	@Selector("setBorderColor:")
	public native void setBorderColor(String value);

	@Generated
	@Selector("setCSSWidth:")
	public native void setCSSWidth(String value);

	@Generated
	@Selector("setChannel:")
	public native void setChannel(String value);

	@Generated
	@Selector("setClickToCallExtensionEnabled:")
	public native void setClickToCallExtensionEnabled(boolean value);

	@Generated
	@Selector("setDescriptionFontSize:")
	public native void setDescriptionFontSize(@NFloat double value);

	@Generated
	@Selector("setDetailedAttributionExtensionEnabled:")
	public native void setDetailedAttributionExtensionEnabled(boolean value);

	@Generated
	@Selector("setDomainLinkColor:")
	public native void setDomainLinkColor(String value);

	@Generated
	@Selector("setDomainLinkFontSize:")
	public native void setDomainLinkFontSize(@NFloat double value);

	@Generated
	@Selector("setFontFamily:")
	public native void setFontFamily(String value);

	@Generated
	@Selector("setHostLanguage:")
	public native void setHostLanguage(String value);

	@Generated
	@Selector("setLocationExtensionEnabled:")
	public native void setLocationExtensionEnabled(boolean value);

	@Generated
	@Selector("setLocationExtensionFontSize:")
	public native void setLocationExtensionFontSize(@NFloat double value);

	@Generated
	@Selector("setLocationExtensionTextColor:")
	public native void setLocationExtensionTextColor(String value);

	@Generated
	@Selector("setLongerHeadlinesExtensionEnabled:")
	public native void setLongerHeadlinesExtensionEnabled(boolean value);

	@Generated
	@Selector("setNumberOfAds:")
	public native void setNumberOfAds(@NInt long value);

	@Generated
	@Selector("setPlusOnesExtensionEnabled:")
	public native void setPlusOnesExtensionEnabled(boolean value);

	@Generated
	@Selector("setQuery:")
	public native void setQuery(String value);

	@Generated
	@Selector("setSellerRatingsExtensionEnabled:")
	public native void setSellerRatingsExtensionEnabled(boolean value);

	@Generated
	@Selector("setSiteLinksExtensionEnabled:")
	public native void setSiteLinksExtensionEnabled(boolean value);

	@Generated
	@Selector("setTextColor:")
	public native void setTextColor(String value);

	@Generated
	@Selector("setTitleFontSize:")
	public native void setTitleFontSize(@NFloat double value);

	@Generated
	@Selector("setTitleLinkColor:")
	public native void setTitleLinkColor(String value);

	@Generated
	@Selector("setTitleUnderlineHidden:")
	public native void setTitleUnderlineHidden(boolean value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("setVerticalSpacing:")
	public native void setVerticalSpacing(@NFloat double value);

	@Generated
	@Selector("siteLinksExtensionEnabled")
	public native boolean siteLinksExtensionEnabled();

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("textColor")
	public native String textColor();

	@Generated
	@Selector("titleFontSize")
	@NFloat
	public native double titleFontSize();

	@Generated
	@Selector("titleLinkColor")
	public native String titleLinkColor();

	@Generated
	@Selector("titleUnderlineHidden")
	public native boolean titleUnderlineHidden();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();

	@Generated
	@Selector("verticalSpacing")
	@NFloat
	public native double verticalSpacing();
}