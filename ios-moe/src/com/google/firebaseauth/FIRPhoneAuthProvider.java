package com.google.firebaseauth;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSError;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import com.google.firebaseauth.protocol.FIRAuthUIDelegate;
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
@Library("FirebaseAuth")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class FIRPhoneAuthProvider extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected FIRPhoneAuthProvider(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native FIRPhoneAuthProvider alloc();

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
	@Selector("credentialWithVerificationID:verificationCode:")
	public native FIRPhoneAuthCredential credentialWithVerificationIDVerificationCode(
			String verificationID, String verificationCode);

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
	public native FIRPhoneAuthProvider init();

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
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("provider")
	public static native FIRPhoneAuthProvider provider();

	@Generated
	@Selector("providerWithAuth:")
	public static native FIRPhoneAuthProvider providerWithAuth(FIRAuth auth);

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("verifyPhoneNumber:UIDelegate:completion:")
	public native void verifyPhoneNumberUIDelegateCompletion(
			String phoneNumber,
			@Mapped(ObjCObjectMapper.class) FIRAuthUIDelegate UIDelegate,
			@ObjCBlock(name = "call_verifyPhoneNumberUIDelegateCompletion") Block_verifyPhoneNumberUIDelegateCompletion completion);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_verifyPhoneNumberUIDelegateCompletion {
		@Generated
		void call_verifyPhoneNumberUIDelegateCompletion(String arg0,
				NSError arg1);
	}

	@Generated
	@Deprecated
	@Selector("verifyPhoneNumber:completion:")
	public native void verifyPhoneNumberCompletion(
			String phoneNumber,
			@ObjCBlock(name = "call_verifyPhoneNumberCompletion") Block_verifyPhoneNumberCompletion completion);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_verifyPhoneNumberCompletion {
		@Generated
		void call_verifyPhoneNumberCompletion(String arg0, NSError arg1);
	}

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}