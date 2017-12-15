package de.tomgrill.gdxfirebase.iosmoe.fcm;

import apple.foundation.NSError;
import apple.foundation.NSProcessInfo;
import apple.uikit.UIApplication;
import apple.uikit.UIUserNotificationSettings;
import apple.uikit.enums.UIUserNotificationType;
import apple.usernotifications.UNNotification;
import apple.usernotifications.UNNotificationResponse;
import apple.usernotifications.UNUserNotificationCenter;
import apple.usernotifications.enums.UNAuthorizationOptions;
import apple.usernotifications.protocol.UNUserNotificationCenterDelegate;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.utils.Array;
import com.google.firebasemessaging.FIRMessaging;
import com.google.firebasemessaging.FIRMessagingRemoteMessage;
import com.google.firebasemessaging.protocol.FIRMessagingDelegate;
import de.tomgrill.gdxfirebase.core.fcm.FirebaseFCM;
import de.tomgrill.gdxfirebase.core.fcm.RemoteMessageListener;
import de.tomgrill.gdxfirebase.core.fcm.TokenRefreshListener;

public class IOSMOEFirebaseFCM implements FirebaseFCM, UNUserNotificationCenterDelegate, FIRMessagingDelegate {


    private Array<TokenRefreshListener> tokenRefreshListeners = new Array<>();
    private Array<RemoteMessageListener> remoteMessageListeners = new Array<>();

    public IOSMOEFirebaseFCM() {

        FIRMessaging.messaging().setDelegate(this);

        if (NSProcessInfo.processInfo().operatingSystemVersion().majorVersion() < 10) {
            // below 10
            long userNotificationTypeBits = UIUserNotificationType.Sound | UIUserNotificationType.Alert | UIUserNotificationType.Badge;
            UIUserNotificationSettings uiUserNotificationSettings = UIUserNotificationSettings.settingsForTypesCategories(userNotificationTypeBits, null);
            UIApplication.alloc().registerUserNotificationSettings(uiUserNotificationSettings);
        } else {
            // with ios 10+
            UNUserNotificationCenter.currentNotificationCenter().setDelegate(this);
            long optionBits = UNAuthorizationOptions.Alert | UNAuthorizationOptions.Sound | UNAuthorizationOptions.Badge;
            UNUserNotificationCenter.currentNotificationCenter().requestAuthorizationWithOptionsCompletionHandler(optionBits, new UNUserNotificationCenter.Block_requestAuthorizationWithOptionsCompletionHandler() {
                @Override
                public void call_requestAuthorizationWithOptionsCompletionHandler(boolean allowed, NSError arg1) {
                    System.out.println("AJAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA COMPLETE AUTH WITH: " + allowed);
                    System.out.println("AJAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA COMPLETE AUTH ERROR: " + arg1);
                }
            });
        }

        UIApplication.alloc().registerForRemoteNotifications();
    }

    @Override
    public void addTokenRefreshListener(TokenRefreshListener tokenRefreshListener) {
    }

    @Override
    public void removeTokenRefreshListener(TokenRefreshListener tokenRefreshListener) {

    }

    @Override
    public void addRemoteMessageListener(RemoteMessageListener remoteMessageListener) {
        remoteMessageListeners.add(remoteMessageListener);
    }

    @Override
    public void removeRemoteMessageListener(RemoteMessageListener remoteMessageListener) {
        remoteMessageListeners.removeValue(remoteMessageListener, true);
    }

    @Override
    public void subscribeToTopic(String topic) {
        FIRMessaging.alloc().subscribeToTopic(topic);
    }

    @Override
    public void unsubscribeFromTopic(String topic) {
        FIRMessaging.alloc().unsubscribeFromTopic(topic);

    }

    @Override
    public void frontUpClean() {

    }

    @Override
    public void userNotificationCenterDidReceiveNotificationResponseWithCompletionHandler(UNUserNotificationCenter center, UNNotificationResponse response, Block_userNotificationCenterDidReceiveNotificationResponseWithCompletionHandler completionHandler) {
        System.out.println("AAHAHAAAAAA RECEIVE MSG");
    }

    @Override
    public void userNotificationCenterWillPresentNotificationWithCompletionHandler(UNUserNotificationCenter center, UNNotification notification, Block_userNotificationCenterWillPresentNotificationWithCompletionHandler completionHandler) {
        System.out.println("AAHAHAAAAAA WILL PRESEN");

    }

    @Override
    public void messagingDidReceiveMessage(FIRMessaging messaging, FIRMessagingRemoteMessage remoteMessage) {
        System.out.println("DIDI RECEIVE MESSAGEEE" + remoteMessage);
    }

    @Override
    public void messagingDidReceiveRegistrationToken(FIRMessaging messaging, String fcmToken) {
        System.out.println("TOKEN REFRESEH " + fcmToken);
    }
}
