package de.tomgrill.gdxfirebase.core.auth;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CustomFirebaseUser implements FirebaseUser {

    private HashMap<String, String> authPayload;

    private String uid;
    private String provider;
    private String name;
    private String photoUrl;
    private String email;
    private String token;
    private boolean anonymous;

    CustomFirebaseUser() {
    }

    @Override
    public String getUid() {
        return uid;
    }

    void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String getProviderId() {
        return provider;
    }

    void setProviderId(String provider) {
        this.provider = provider;
    }

    @Override
    public boolean isAnonymous() {
        return anonymous;
    }

    void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    @Override
    public List<String> getProviders() {
        Gdx.app.debug("gdx-firebase", "getProviders() not supported here. Will return empty list.");
        return new ArrayList<>();
    }

    @Override
    public String getDisplayName() {
        return name;
    }


    void setDisplayName(String name) {
        this.name = name;
    }

    @Override
    public String getPhotoUrl() {
        return photoUrl;
    }

    void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getToken(boolean var1) {
        return token;
    }

    void setToken(String token) {
        this.token = token;
    }

    @Override
    public void reload() {
        Gdx.app.debug("gdx-firebase", "reload() not supported here.");
    }

    @Override
    public void reauthenticate(AuthCredential var1) {
        Gdx.app.debug("gdx-firebase", "reauthenticate() not supported here.");
    }

    @Override
    public Task<AuthResult> linkWithCredential(AuthCredential var1) {
        Gdx.app.debug("gdx-firebase", "linkWithGoogle() not supported here.");
        return new Task<AuthResult>() {
            @Override
            public boolean isComplete() {
                return false;
            }

            @Override
            public boolean isSuccessful() {
                return false;
            }

            @Override
            public Task<AuthResult> addOnCompleteListener(OnCompleteListener<AuthResult> var1) {
                return this;
            }

            @Override
            public Exception getException() {
                return new GdxFirebaseException("linkWithGoogle() not supported");
            }

            //            @Override
//            public Task<AuthResult> addOnSuccessListener(OnSuccessListener<AuthResult> var1) {
//                return null;
//            }

        };
    }

    @Override
    public void unlink(String var1) {
        Gdx.app.debug("gdx-firebase", "unlink() not supported here.");
    }

    @Override
    public void updateEmail(String var1) {
        Gdx.app.debug("gdx-firebase", "updateEmail() not supported here.");
    }

    @Override
    public void updatePassword(String var1) {
        Gdx.app.debug("gdx-firebase", "updatePassword() not supported here.");
    }

    @Override
    public void delete() {
        Gdx.app.debug("gdx-firebase", "delete() not supported here.");
    }

    HashMap<String, String> getAuthPayload() {
        return authPayload;
    }

    void setAuthPayload(HashMap<String, String> authPayload) {
        this.authPayload = authPayload;
    }
}
