package de.tomgrill.gdxfirebase.desktop.auth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.auth.*;

public class DefaultDesktopFirebaseAuth implements FirebaseAuth {


    private Array<AuthStateListener> authStateListeners;

    private FirebaseUser firebaseUser;

    private boolean isSignedIn;

    public DefaultDesktopFirebaseAuth(String name, FirebaseConfiguration firebaseConfiguration) {
        authStateListeners = new Array<>();
        firebaseUser = firebaseConfiguration.desktopFirebaseUser;
    }


    @Override
    public FirebaseUser getCurrentUser() {
        if(!isSignedIn) {
            return null;
        }
        return firebaseUser;
    }

    @Override
    public void addAuthStateListener(AuthStateListener authStateListener) {
        authStateListeners.add(authStateListener);
    }

    @Override
    public void removeAuthStateListener(AuthStateListener authStateListener) {
        authStateListeners.removeValue(authStateListener, true);
    }

    @Override
    public void signInWithCredential(AuthCredential authCredential) {
        isSignedIn = true;
        informListeners();
        Gdx.app.debug("gdx-firebase", "signInWithCredential will always sign in the user on Desktop platform.");
    }

    @Override
    public void signInWithCustomToken(String token) {
        isSignedIn = true;
        informListeners();
        Gdx.app.debug("gdx-firebase", "signInWithCustomToken will always sign in the user on Desktop platform.");
    }

    @Override
    public void signInWithEmailAndPassword(String email, String password) {
        isSignedIn = true;
        informListeners();
        Gdx.app.debug("gdx-firebase", "signInWithEmailAndPassword will always sign in the user on Desktop platform.");
    }

    @Override
    public void signInAnonymously() {
        isSignedIn = true;
        informListeners();
        Gdx.app.debug("gdx-firebase", "signInAnonymously will always sign in the user on Desktop platform.");
    }

    @Override
    public void signInAnonymously(OnCompleteListener<AuthResult> onCompleteListener) {
        isSignedIn = true;
        informListeners();
        onCompleteListener.onComplete(new DesktopTask<AuthResult>(true, true));
        Gdx.app.debug("gdx-firebase", "signInAnonymously will always sign in the user on Desktop platform.");
    }

    @Override
    public void createUserWithEmailAndPassword(String email, String password) {
        isSignedIn = true;
        informListeners();
        Gdx.app.debug("gdx-firebase", "createUserWithEmailAndPassword  will always fake create the user on Desktop platform.");
    }

    @Override
    public void fetchProvidersForEmail(String email) {
        Gdx.app.debug("gdx-firebase", "fetchProvidersForEmail is not supported on Desktop platform");
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        Gdx.app.debug("gdx-firebase", "sendPasswordResetEmail is not supported on Desktop platform");
    }

    @Override
    public void signOut() {
        isSignedIn = false;
        informListeners();
    }

    @Override
    public AuthProvider FacebookAuthProvider(String accessToken) {
        return new DesktopFacebookAuthProvider(accessToken);
    }

    @Override
    public AuthProvider GoogleAuthProvider(String accessToken) {
        return null;
    }

    @Override
    public void signInWithGoogle(OnCompleteListener<AuthResult> onCompleteListener) {
        Gdx.app.debug("gdx-firebase", "signInWithGoogle is not supported on Desktop platform");
        onCompleteListener.onComplete(new DesktopTask<AuthResult>(true,false));
    }

    @Override
    public void linkWithGoogle(OnCompleteListener<AuthResult> onCompleteListener) {
        Gdx.app.debug("gdx-firebase", "linkWithGoogle is not supported on Desktop platform");
        onCompleteListener.onComplete(new DesktopTask<AuthResult>(true,false));
    }

    private void informListeners() {
        for(AuthStateListener listener : authStateListeners) {
            listener.onAuthStateChanged(this);
        }
    }
}
