package de.tomgrill.gdxfirebase.iosmoe.auth;


import apple.foundation.NSError;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.iosmoe.IOSApplication;
import com.badlogic.gdx.utils.Array;
import com.google.firebaseauth.FIRAuth;
import com.google.firebaseauth.FIRUser;
import com.google.firebasecore.FIRApp;
import de.tomgrill.gdxfirebase.core.auth.*;
import de.tomgrill.gdxfirebase.iosmoe.ConfigureOverwatch;


public class IOSMOEFirebaseAuth implements FirebaseAuth {

    private Array<FIRAuth.Block_addAuthStateDidChangeListener> fbAuthStateListeners;
    private Array<AuthStateListener> authStateListeners;

    public IOSMOEFirebaseAuth() {
        if(!ConfigureOverwatch.isConfigured) {
            FIRApp.configure();
            ConfigureOverwatch.isConfigured = true;
        }

        fbAuthStateListeners = new Array<>();
        authStateListeners = new Array<>();
    }

    @Override
    public FirebaseUser getCurrentUser() {
        if (FIRAuth.auth().currentUser() == null) {
            return null;
        }
        return new IOSMOEFirebaseUser(FIRAuth.auth().currentUser());
    }

    @Override
    public void addAuthStateListener(final AuthStateListener authStateListener) {
        FIRAuth.Block_addAuthStateDidChangeListener fbListener = new FIRAuth.Block_addAuthStateDidChangeListener() {
            @Override
            public void call_addAuthStateDidChangeListener(FIRAuth arg0, FIRUser arg1) {
                authStateListener.onAuthStateChanged(IOSMOEFirebaseAuth.this);
            }
        };

        FIRAuth.auth().addAuthStateDidChangeListener(fbListener);
        fbAuthStateListeners.add(fbListener);
        authStateListeners.add(authStateListener);
    }

    @Override
    public void removeAuthStateListener(final AuthStateListener authStateListener) {
        int index = authStateListeners.indexOf(authStateListener, true);
        if (index == -1) {
            throw new RuntimeException("Unknown AuthStateListener. Already removed or not added.");
        }
        FIRAuth.auth().removeAuthStateDidChangeListener((FIRAuth.Block_addAuthStateDidChangeListener) fbAuthStateListeners.get(index));
        fbAuthStateListeners.removeIndex(index);
        authStateListeners.removeIndex(index);
    }

    @Override
    public void signInWithCredential(AuthCredential authCredential) {
        FIRAuth.auth().signInWithCredentialCompletion(((IOSMOEAuthCredential) authCredential).getFIRAuthCredential(), new FIRAuth.Block_signInWithCredentialCompletion() {
            @Override
            public void call_signInWithCredentialCompletion(FIRUser arg0, NSError arg1) {
                // do nothing
            }
        });
    }

    @Override
    public void signInWithCustomToken(String token) {
        FIRAuth.auth().signInWithCustomTokenCompletion(token, new FIRAuth.Block_signInWithCustomTokenCompletion() {
            @Override
            public void call_signInWithCustomTokenCompletion(FIRUser arg0, NSError arg1) {
                // do nothing
            }
        });
    }

    @Override
    public void signInWithEmailAndPassword(String email, String password) {
        FIRAuth.auth().signInWithEmailPasswordCompletion(email, password, new FIRAuth.Block_signInWithEmailPasswordCompletion() {
            @Override
            public void call_signInWithEmailPasswordCompletion(FIRUser arg0, NSError arg1) {
                // do nothing
            }
        });
    }

    @Override
    public void signInAnonymously() {
        FIRAuth.auth().signInAnonymouslyWithCompletion(new FIRAuth.Block_signInAnonymouslyWithCompletion() {
            @Override
            public void call_signInAnonymouslyWithCompletion(FIRUser firebaseUSer, NSError error) {
                // do nothing
            }
        });
    }

    @Override
    public void signInAnonymously(final OnCompleteListener<AuthResult> onCompleteListener) {
        FIRAuth.auth().signInAnonymouslyWithCompletion(new FIRAuth.Block_signInAnonymouslyWithCompletion() {
            @Override
            public void call_signInAnonymouslyWithCompletion(FIRUser firebaseUSer, NSError error) {

                if(error != null) {
                    IOSMOETask<AuthResult> iosmoeTask = new IOSMOETask<>(true, false, new Exception(error.localizedDescription()));
                    onCompleteListener.onComplete(iosmoeTask);
                } else {
                    IOSMOETask<AuthResult>  iosmoeTask = new IOSMOETask<> (true, true, null);
                    onCompleteListener.onComplete(iosmoeTask);
                }

            }
        });
    }

    @Override
    public void createUserWithEmailAndPassword(String email, String password) {
        FIRAuth.auth().createUserWithEmailPasswordCompletion(email, password, new FIRAuth.Block_createUserWithEmailPasswordCompletion() {
            @Override
            public void call_createUserWithEmailPasswordCompletion(FIRUser arg0, NSError arg1) {
                // do nothing
            }
        });
    }

    @Override
    public void fetchProvidersForEmail(String email) {
        // TODO
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        FIRAuth.auth().sendPasswordResetWithEmailCompletion(email, new FIRAuth.Block_sendPasswordResetWithEmailCompletion() {
            @Override
            public void call_sendPasswordResetWithEmailCompletion(NSError arg0) {
                // do nothing
            }
        });
    }

    @Override
    public void signOut() {
        FIRAuth.auth().signOut(null);
    }

    @Override
    public AuthProvider FacebookAuthProvider(String accessToken) {
        return null;
    }

    @Override
    public AuthProvider GoogleAuthProvider(String accessToken) {
        return new IOEMOEGoogleAuthProvider(accessToken);
    }

//    @Override
//    public void linkWithGoogle(final String tokenId, final OnCompleteListener<AuthResult> onCompleteListener) {
//        if(onCompleteListener == null) return;
//
//        FIRAuthCredential firAuthCredential = FIRGoogleAuthProvider.credentialWithIDTokenAccessToken(tokenId, null); // TODO
//        FIRAuth.auth().currentUser().linkWithCredentialCompletion(firAuthCredential, new FIRUser.Block_linkWithCredentialCompletion() {
//            @Override
//            public void call_linkWithCredentialCompletion(FIRUser arg0, NSError arg1) {
//
//            }
//        });
//    }

//    @Override
//    public void signInWithGoogle(OnCompleteListener<AuthResult> onCompleteListener) {
//        GIDSignIn.sharedInstance().signIn();
//    }

//    @Override
//    public void linkWithGoogle(OnCompleteListener<AuthResult> onCompleteListener) {
//        // TODO
//    }
}
