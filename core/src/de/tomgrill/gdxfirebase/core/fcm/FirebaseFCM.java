package de.tomgrill.gdxfirebase.core.fcm;

public interface FirebaseFCM {

    void addTokenRefreshListener(TokenRefreshListener tokenRefreshListener);

    void removeTokenRefreshListener(TokenRefreshListener tokenRefreshListener);

    void addRemoteMessageListener(RemoteMessageListener remoteMessageListener);

    void removeRemoteMessageListener(RemoteMessageListener remoteMessageListener);
}
