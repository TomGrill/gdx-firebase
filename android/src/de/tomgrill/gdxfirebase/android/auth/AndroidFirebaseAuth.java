package de.tomgrill.gdxfirebase.android.auth;

import android.support.annotation.NonNull;
import android.util.Log;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.auth.AuthCredential;
import de.tomgrill.gdxfirebase.core.auth.AuthStateListener;
import de.tomgrill.gdxfirebase.core.auth.FirebaseAuth;
import de.tomgrill.gdxfirebase.core.auth.FirebaseUser;

public class AndroidFirebaseAuth implements FirebaseAuth {

    private com.google.firebase.auth.FirebaseAuth firebaseAuth;

    private Array<com.google.firebase.auth.FirebaseAuth.AuthStateListener> fbAuthStateListeners;
    private Array<AuthStateListener> authStateListeners;


    public AndroidFirebaseAuth(String name, FirebaseConfiguration firebaseConfiguration) {
        this.firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        fbAuthStateListeners = new Array<>();
        authStateListeners = new Array<>();
    }

    @Override
    public FirebaseUser getCurrentUser() {
        if(firebaseAuth.getCurrentUser() == null) {
            return null;
        }
        return new AndroidFirebaseUser(firebaseAuth.getCurrentUser());
    }

    @Override
    public void addAuthStateListener(final AuthStateListener authStateListener) {

        com.google.firebase.auth.FirebaseAuth.AuthStateListener fbListener = new com.google.firebase.auth.FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull com.google.firebase.auth.FirebaseAuth firebaseAuth) {
                authStateListener.onAuthStateChanged(AndroidFirebaseAuth.this);
            }
        };

        firebaseAuth.addAuthStateListener(fbListener);
        fbAuthStateListeners.add(fbListener);
        authStateListeners.add(authStateListener);
    }

    @Override
    public void removeAuthStateListener(AuthStateListener authStateListener) {
        int index = authStateListeners.indexOf(authStateListener, true);
        if (index == -1) {
            throw new RuntimeException("Unknown AuthStateListener. Already removed or not added.");
        }
        firebaseAuth.removeAuthStateListener(fbAuthStateListeners.get(index));
        fbAuthStateListeners.removeIndex(index);
        authStateListeners.removeIndex(index);
    }

    @Override
    public void signInWithCredential(AuthCredential authCredential) {
        firebaseAuth.signInWithCredential(((AndroidAuthCredential) authCredential).getFirebaseAuthCredential());
    }

    @Override
    public void signInWithCustomToken(String token) {
        firebaseAuth.signInWithCustomToken(token);
    }

    @Override
    public void signInWithEmailAndPassword(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password);
    }

    @Override
    public void signInAnonymously() {
        firebaseAuth.signInAnonymously();
    }

    @Override
    public void createUserWithEmailAndPassword(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password);
    }

    @Override
    public void fetchProvidersForEmail(String email) {
        // TODO
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        firebaseAuth.sendPasswordResetEmail(email);
    }

    @Override
    public void signOut() {
        firebaseAuth.signOut();
    }

}
