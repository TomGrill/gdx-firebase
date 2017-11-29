package de.tomgrill.gdxfirebase.android.fcm;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.utils.Array;
import com.google.firebase.iid.FirebaseInstanceId;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.fcm.FirebaseFCM;
import de.tomgrill.gdxfirebase.core.fcm.RemoteMessage;
import de.tomgrill.gdxfirebase.core.fcm.RemoteMessageListener;
import de.tomgrill.gdxfirebase.core.fcm.TokenRefreshListener;

import java.io.Serializable;

public class AndroidFirebaseFCM implements FirebaseFCM, LifecycleListener {

    private final Activity activity;
    private final FirebaseConfiguration firebaseConfiguration;
    private final FCMDataReceiver fcmDataReceiver;
    private final TokenRefreshReceiver tokenRefreshReceiver;

    private Array<TokenRefreshListener> tokenRefreshListeners = new Array<>();
    private Array<RemoteMessageListener> remoteMessageListeners = new Array<>();

    public AndroidFirebaseFCM(Activity activity, FirebaseConfiguration firebaseConfiguration) {
        this.activity = activity;
        this.firebaseConfiguration = firebaseConfiguration;

        {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Action.MESSAGE_SERVICE);
            fcmDataReceiver = new FCMDataReceiver();
            activity.registerReceiver(fcmDataReceiver, intentFilter);
        }

        {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Action.TOKEN_REFRESH);
            tokenRefreshReceiver = new TokenRefreshReceiver();
            activity.registerReceiver(tokenRefreshReceiver, intentFilter);
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        activity.unregisterReceiver(tokenRefreshReceiver);
        activity.unregisterReceiver(fcmDataReceiver);
    }

    @Override
    public void addTokenRefreshListener(TokenRefreshListener tokenRefreshListener) {
        tokenRefreshListener.onTokenRefresh(FirebaseInstanceId.getInstance().getToken());
        tokenRefreshListeners.add(tokenRefreshListener);
    }

    @Override
    public void removeTokenRefreshListener(TokenRefreshListener tokenRefreshListener) {
        tokenRefreshListeners.removeValue(tokenRefreshListener, true);
    }

    @Override
    public void addRemoteMessageListener(RemoteMessageListener remoteMessageListener) {
        remoteMessageListeners.add(remoteMessageListener);
    }

    @Override
    public void removeRemoteMessageListener(RemoteMessageListener remoteMessageListener) {
        remoteMessageListeners.removeValue(remoteMessageListener, true);
    }


    private class FCMDataReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.hasExtra("message")) {

                Serializable serializable = intent.getSerializableExtra("message");

                if (serializable != null && serializable instanceof RemoteMessage) {
                    RemoteMessage remoteMessage = (RemoteMessage) serializable;

                    for (int i = 0; i < remoteMessageListeners.size; i++) {
                        remoteMessageListeners.get(i).onRemoteMessage(remoteMessage);
                    }
                }
            }
        }
    }

    private class TokenRefreshReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("token")) {
                String token = intent.getStringExtra("token");
                for (int i = 0; i < tokenRefreshListeners.size; i++) {
                    tokenRefreshListeners.get(i).onTokenRefresh(token);
                }
            }
        }
    }

}
