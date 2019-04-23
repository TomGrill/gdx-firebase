package de.tomgrill.gdxfirebase.bindings.pac;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSError;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import apple.foundation.NSURL;
import apple.uikit.UIViewController;
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
public class PACConsentForm extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected PACConsentForm(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native PACConsentForm alloc();

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
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native PACConsentForm init();

	@Generated
	@Selector("initWithApplicationPrivacyPolicyURL:")
	public native PACConsentForm initWithApplicationPrivacyPolicyURL(
			NSURL privacyPolicyURL);

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
	@Selector("loadWithCompletionHandler:")
	public native void loadWithCompletionHandler(
			@ObjCBlock(name = "call_loadWithCompletionHandler") Block_loadWithCompletionHandler loadCompletion);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_loadWithCompletionHandler {
		@Generated
		void call_loadWithCompletionHandler(NSError arg0);
	}

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("presentFromViewController:dismissCompletion:")
	public native void presentFromViewControllerDismissCompletion(
			UIViewController viewController,
			@ObjCBlock(name = "call_presentFromViewControllerDismissCompletion") Block_presentFromViewControllerDismissCompletion completionHandler);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_presentFromViewControllerDismissCompletion {
		@Generated
		void call_presentFromViewControllerDismissCompletion(NSError arg0,
				boolean arg1);
	}

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setShouldOfferAdFree:")
	public native void setShouldOfferAdFree(boolean value);

	@Generated
	@Selector("setShouldOfferNonPersonalizedAds:")
	public native void setShouldOfferNonPersonalizedAds(boolean value);

	@Generated
	@Selector("setShouldOfferPersonalizedAds:")
	public native void setShouldOfferPersonalizedAds(boolean value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("shouldOfferAdFree")
	public native boolean shouldOfferAdFree();

	@Generated
	@Selector("shouldOfferNonPersonalizedAds")
	public native boolean shouldOfferNonPersonalizedAds();

	@Generated
	@Selector("shouldOfferPersonalizedAds")
	public native boolean shouldOfferPersonalizedAds();

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}