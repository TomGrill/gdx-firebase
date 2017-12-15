package com.google.firebasemessaging.protocol;


import com.google.firebasemessaging.FIRMessaging;
import com.google.firebasemessaging.FIRMessagingRemoteMessage;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("FirebaseMessaging")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("FIRMessagingDelegate")
public interface FIRMessagingDelegate {
	@Generated
	@IsOptional
	@Deprecated
	@Selector("applicationReceivedRemoteMessage:")
	default void applicationReceivedRemoteMessage(
			FIRMessagingRemoteMessage remoteMessage) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("messaging:didReceiveMessage:")
	default void messagingDidReceiveMessage(FIRMessaging messaging,
			FIRMessagingRemoteMessage remoteMessage) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("messaging:didReceiveRegistrationToken:")
	default void messagingDidReceiveRegistrationToken(FIRMessaging messaging,
			String fcmToken) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Deprecated
	@Selector("messaging:didRefreshRegistrationToken:")
	default void messagingDidRefreshRegistrationToken(FIRMessaging messaging,
			String fcmToken) {
		throw new java.lang.UnsupportedOperationException();
	}
}