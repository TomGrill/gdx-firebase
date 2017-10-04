package de.tomgrill.gdxfirebase.iosmoe.auth;

import apple.foundation.NSError;
import de.tomgrill.gdxfirebase.bindings.firebaseauth.FIRUser;
import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthResult;
import de.tomgrill.gdxfirebase.core.auth.FirebaseUser;
import de.tomgrill.gdxfirebase.core.auth.Task;

import java.util.ArrayList;
import java.util.List;

public class IOSMOEFirebaseUser implements FirebaseUser {

    private FIRUser firUser;
    private ArrayList<String> providers;

    public IOSMOEFirebaseUser(FIRUser firUser) {
        this.firUser = firUser;
    }

    @Override
    public String getUid() {
        return firUser.uid();
    }

    @Override
    public String getProviderId() {
        return firUser.providerID();
    }

    @Override
    public boolean isAnonymous() {
        return firUser.isAnonymous();
    }

    @Override
    public List<String> getProviders() {
        providers.clear();
        for (int i = 0; i < firUser.providerData().size(); i++) {
            providers.add((String) firUser.providerData().get(i));
        }
        return providers;
    }

    @Override
    public String getDisplayName() {
        return firUser.displayName();
    }

    @Override
    public String getPhotoUrl() {
        return firUser.photoURL().absoluteString();
    }

    @Override
    public String getEmail() {
        return firUser.email();
    }

    @Override
    public String getToken(boolean forceRefresh) {
        return firUser.refreshToken();
    }

    @Override
    public void reload() {
        // TODO
    }

    @Override
    public void reauthenticate(AuthCredential authCredential) {
        // TODO
    }

    @Override
    public Task<AuthResult> linkWithCredential(AuthCredential authCredential) {
        firUser.linkWithCredentialCompletion(null, new FIRUser.Block_linkWithCredentialCompletion() {
            @Override
            public void call_linkWithCredentialCompletion(FIRUser firUser, NSError error) {

            }
        });
        return null;
    }

    @Override
    public void unlink(String s) {

    }

    @Override
    public void updateEmail(String email) {

    }

    @Override
    public void updatePassword(String password) {

    }

    @Override
    public void delete() {

    }
}
