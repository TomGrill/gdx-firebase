package de.tomgrill.gdxfirebase.core.auth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FirebaseUserBuilder {

    private HashMap<String, String> authPayload;

    private String uid;
    private String provider;
    private String name;
    private String photoUrl;
    private String email;
    private String token;
    private boolean anonymous;

    private final Json json = new Json(JsonWriter.OutputType.json);


    public FirebaseUserBuilder(String absolutePathToFirebaseUserJsonFile) {

        String fileContent = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(absolutePathToFirebaseUserJsonFile));

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            fileContent = sb.toString();

        } catch (IOException e) {
            Gdx.app.debug("gdx-firebase", "Cannot find file " + absolutePathToFirebaseUserJsonFile + ". This may be an exception to solve when you want to use this file. You can ignore this exception when you do not need this file in your current built.");
        }

        if (fileContent != null) {
            CustomFirebaseUser firebaseUser = json.fromJson(CustomFirebaseUser.class, fileContent);
            uid = firebaseUser.getUid();
            provider = firebaseUser.getProviderId();
            name = firebaseUser.getDisplayName();
            photoUrl = firebaseUser.getPhotoUrl();
            email = firebaseUser.getEmail();
            token = firebaseUser.getToken(true);
            anonymous = firebaseUser.isAnonymous();
            authPayload = firebaseUser.getAuthPayload();
        }
    }

    public FirebaseUserBuilder() {
        authPayload = new HashMap<>();
    }

    public FirebaseUserBuilder setUid(String uid) {
        this.uid = uid;
        authPayload.put("uid", uid);
        return this;
    }

    public FirebaseUserBuilder setProviderId(String providerId) {
        this.provider = providerId;
        return this;
    }

    public FirebaseUserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FirebaseUserBuilder setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public FirebaseUserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public FirebaseUserBuilder setToken(String token) {
        this.token = token;
        return this;
    }

    public FirebaseUserBuilder setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
        return this;
    }

    public FirebaseUserBuilder putAuthPayload(String key, String value) {
        if (key.equals("uid")) {
            this.uid = value;
        }
        authPayload.put(key, value);
        return this;
    }


    public FirebaseUser build() {
        CustomFirebaseUser customFirebaseUser = new CustomFirebaseUser();
        customFirebaseUser.setAnonymous(anonymous);
        customFirebaseUser.setAuthPayload(authPayload);
        customFirebaseUser.setDisplayName(name);
        customFirebaseUser.setEmail(email);
        customFirebaseUser.setPhotoUrl(photoUrl);
        customFirebaseUser.setProviderId(provider);
        customFirebaseUser.setToken(token);
        customFirebaseUser.setUid(uid);
        return customFirebaseUser;
    }

    public String prettyPrint() {
        return json.prettyPrint(build());
    }
}
