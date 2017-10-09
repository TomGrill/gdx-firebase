package de.tomgrill.gdxfirebase.android.auth;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidEventListener;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.badlogic.gdx.utils.Array;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.GoogleAuthProvider;
import de.tomgrill.gdxfirebase.core.FirebaseConfiguration;
import de.tomgrill.gdxfirebase.core.auth.*;

public class AndroidFirebaseAuth implements FirebaseAuth, AndroidEventListener {

    private final static int REQUEST_CODE_SIGN_IN_WITH_GOOGLE = 33113309;
    private final static int REQUEST_CODE_LINK_WITH_GOOGLE = 33113310;

    private final FirebaseConfiguration firebaseConfiguration;
    private final Activity activity;
    private com.google.firebase.auth.FirebaseAuth firebaseAuth;

    private GoogleApiClient mGoogleApiClient;

    private Array<com.google.firebase.auth.FirebaseAuth.AuthStateListener> fbAuthStateListeners;
    private Array<AuthStateListener> authStateListeners;

    private de.tomgrill.gdxfirebase.core.auth.OnCompleteListener<AuthResult> onCompleteListener;
    private boolean signInProcessRunning;

    public AndroidFirebaseAuth(Activity activity, FirebaseConfiguration firebaseConfiguration) {
        this.firebaseConfiguration = firebaseConfiguration;
        this.activity = activity;
        this.firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        fbAuthStateListeners = new Array<>();
        authStateListeners = new Array<>();


        if (Gdx.app instanceof AndroidApplication) {
            ((AndroidApplication) Gdx.app).addAndroidEventListener(this);
        } else if (Gdx.app instanceof AndroidFragmentApplication) {
            ((AndroidFragmentApplication) Gdx.app).addAndroidEventListener(this);
        }
    }

    @Override
    public FirebaseUser getCurrentUser() {
        if (firebaseAuth.getCurrentUser() == null) {
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
    public void signInAnonymously(final OnCompleteListener<AuthResult> onCompleteListener) {
        firebaseAuth.signInAnonymously().addOnCompleteListener(new com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> task) {
                onCompleteListener.onComplete(new AndroidTask<AuthResult>(task));
            }
        });
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

    @Override
    public AuthProvider FacebookAuthProvider(String accessToken) {
        return new AndroidFacebookAuthProvider(accessToken);
    }

    @Override
    public AuthProvider GoogleAuthProvider(String accessToken) {
        return new AndroidGoogleAuthProvider(accessToken);
    }

//    @Override
//    public void linkWithGoogle(final String tokenId, final OnCompleteListener<AuthResult> onCompleteListener) {
//        if(onCompleteListener == null) return;
//
//        com.google.firebase.auth.AuthCredential credential = GoogleAuthProvider.getCredential(tokenId, null);
//        com.google.firebase.auth.FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//        if (firebaseUser != null) {
//            firebaseUser.linkWithCredential(credential).addOnCompleteListener(new com.google.android.gms.tasks.OnCompleteListener<com.google.firebase.auth.AuthResult>() {
//                @Override
//                public void onComplete(@NonNull com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> task) {
//
//                    signInProcessRunning = false;
//                    if (task.isSuccessful()) {
//                        Gdx.app.debug("gdx-firebase", "Linked in with Google successfully");
//                        onCompleteListener.onComplete(new AndroidTask<AuthResult>(task));
//                    } else {
//                        Gdx.app.debug("gdx-firebase", "Link in with Google FAILED: " + task.getException().toString());
//                        onCompleteListener.onComplete(new AndroidTask<AuthResult>(task));
//                    }
//                }
//            });
//        } else {
//            Gdx.app.debug("gdx-firebase", "Link with Google failed: Current user is NULL, cannot link.");
//            signInProcessRunning = false;
//            onCompleteListener.onComplete(new AndroidTask<AuthResult>(true, false, new GdxFirebaseException("Current user is NULL, cannot link.")));
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
