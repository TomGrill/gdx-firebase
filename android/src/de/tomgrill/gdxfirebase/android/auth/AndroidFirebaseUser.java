package de.tomgrill.gdxfirebase.android.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthResult;
import de.tomgrill.gdxfirebase.core.auth.FirebaseUser;
import de.tomgrill.gdxfirebase.core.auth.Task;

import java.util.List;

public class AndroidFirebaseUser implements FirebaseUser {
    private com.google.firebase.auth.FirebaseUser firebaseUser;

    public AndroidFirebaseUser(com.google.firebase.auth.FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

    @Override
    public String getUid() {
        return firebaseUser.getUid();
    }

    @Override
    public String getProviderId() {
        return firebaseUser.getProviderId();
    }

    @Override
    public boolean isAnonymous() {
        return firebaseUser.isAnonymous();
    }

    @Override
    public List<String> getProviders() {
        return firebaseUser.getProviders();
    }

    @Override
    public String getDisplayName() {
        return firebaseUser.getDisplayName();
    }

    @Override
    public String getPhotoUrl() {
        return firebaseUser.getPhotoUrl().toString();
    }

    @Override
    public String getEmail() {
        return firebaseUser.getEmail();
    }

    @Override
    public String getToken(boolean forceRefresh) {
        return firebaseUser.getToken(forceRefresh).getResult().getToken();
    }

    @Override
    public void reload() {
        firebaseUser.reload();
    }

    @Override
    public void reauthenticate(AuthCredential authCredential) {
        firebaseUser.reauthenticate(((AndroidAuthCredential) authCredential).getFirebaseAuthCredential());
    }

    @Override
    public Task<AuthResult> linkWithCredential(AuthCredential authCredential) {
        return new AndroidTask<AuthResult>(firebaseUser.linkWithCredential(((AndroidAuthCredential) authCredential).getFirebaseAuthCredential()));
    }

    @Override
    public void unlink(String s) {
        firebaseUser.unlink(s);
    }

    @Override
    public void updateEmail(String email) {
        firebaseUser.updateEmail(email);
    }

    @Override
    public void updatePassword(String password) {
        firebaseUser.updatePassword(password);
    }

    @Override
    public void delete() {
        firebaseUser.delete();
    }
}
