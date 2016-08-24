package de.tomgrill.gdxfirebase.core.auth;

import java.util.List;

public interface FirebaseUser {

    String getUid();

    String getProviderId();

    boolean isAnonymous();

    List<String> getProviders();

//    List<? extends UserInfo> getProviderData(); TODO

    String getDisplayName();

    String getPhotoUrl();

    String getEmail();

    String getToken(boolean forceRefresh);

    void reload();

    void reauthenticate(AuthCredential authCredential);


    void linkWithCredential(AuthCredential authCredential);

    void unlink(String s);

//    void updateProfile( UserProfileChangeRequest var1); TODO

    void updateEmail(String email);

    void updatePassword(String password);

    void delete();

}
