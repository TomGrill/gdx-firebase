package de.tomgrill.gdxfirebase.core.auth;

public interface FirebaseAuth {

    FirebaseUser getCurrentUser();

    void addAuthStateListener(final AuthStateListener authStateListener);

    void removeAuthStateListener(AuthStateListener authStateListener);

    void signInWithCredential(AuthCredential authCredential);

    void signInWithCustomToken(String token);

    void signInWithEmailAndPassword(String email, String password);

    void signInAnonymously();

    void signInAnonymously(OnCompleteListener<AuthResult> onCompleteListener);

    void createUserWithEmailAndPassword(String email, String password);

    void fetchProvidersForEmail(String email);

    void sendPasswordResetEmail(String email);

    void signOut();

    AuthProvider FacebookAuthProvider(String accessToken);

    AuthProvider GoogleAuthProvider(String accessToken);

    /*
    maybe we want to have the login dialogs in another class/extension?
     */

    /**
     * Signs the user in with Google, only on Android. Use linkWithGoogle when you want to link the current user
     * with Google
     * @param onCompleteListener
     */
    void signInWithGoogle(OnCompleteListener<AuthResult> onCompleteListener);

    /**
     * Tries to login with google and links the current user
     */
    void linkWithGoogle(OnCompleteListener<AuthResult> onCompleteListener);
}
