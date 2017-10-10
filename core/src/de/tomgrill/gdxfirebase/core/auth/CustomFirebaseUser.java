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

    @Override
    public void linkWithGoogle(String tokenId, OnCompleteListener<AuthResult> onCompleteListener) {

    }

    void setToken(String token) {
        this.token = token;
    }

    HashMap<String, String> getAuthPayload() {
        return authPayload;
    }

    void setAuthPayload(HashMap<String, String> authPayload) {
        this.authPayload = authPayload;
    }
}
