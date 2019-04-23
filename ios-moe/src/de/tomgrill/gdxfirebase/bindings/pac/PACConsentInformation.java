package de.tomgrill.gdxfirebase.bindings.pac;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSError;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
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
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("PersonalizedAdConsent")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class PACConsentInformation extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected PACConsentInformation(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Selector("adProviders")
	public native NSArray<? extends PACAdProvider> adProviders();

	@Generated
	@Owned
	@Selector("alloc")
	public static native PACConsentInformation alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

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
	@Selector("consentStatus")
	@NInt
	public native long consentStatus();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("debugGeography")
	@NInt
	public native long debugGeography();

	@Generated
	@Selector("debugIdentifiers")
	public native NSArray<String> debugIdentifiers();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native PACConsentInformation init();

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
	@Selector("isRequestLocationInEEAOrUnknown")
	public native boolean isRequestLocationInEEAOrUnknown();

	@Generated
	@Selector("isSubclassOfClass:")
	public static native boolean isSubclassOfClass(Class aClass);

	@Generated
	@Selector("isTaggedForUnderAgeOfConsent")
	public native boolean isTaggedForUnderAgeOfConsent();

	@Generated
	@Selector("keyPathsForValuesAffectingValueForKey:")
	public static native NSSet<String> keyPathsForValuesAffectingValueForKey(
			String key);

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("requestConsentInfoUpdateForPublisherIdentifiers:completionHandler:")
	public native void requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler(
			NSArray<String> publisherIdentifiers,
			@ObjCBlock(name = "call_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler") Block_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler handler);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler {
		@Generated
		void call_requestConsentInfoUpdateForPublisherIdentifiersCompletionHandler(
				NSError arg0);
	}

	@Generated
	@Selector("reset")
	public native void reset();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setConsentStatus:")
	public native void setConsentStatus(@NInt long value);

	@Generated
	@Selector("setDebugGeography:")
	public native void setDebugGeography(@NInt long value);

	@Generated
	@Selector("setDebugIdentifiers:")
	public native void setDebugIdentifiers(NSArray<String> value);

	@Generated
	@Selector("setTagForUnderAgeOfConsent:")
	public native void setTagForUnderAgeOfConsent(boolean value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("sharedInstance")
	public static native PACConsentInformation sharedInstance();

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}