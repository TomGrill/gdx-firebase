package de.tomgrill.gdxfirebase.core.auth;

public interface FirebaseAuth {

    FirebaseUser getCurrentUser();

    void addAuthStateListener(final AuthStateListener authStateListener);

    void removeAuthStateListener(AuthStateListener authStateListener);

    void signInWithCredential(AuthCredential authCredential);

    void signInWithCustomToken(String token);

    void signInWithEmailAndPassword(String email, String password);

    void signInAnonymously();

    void createUserWithEmailAndPassword(String email, String password);

    void fetchProvidersForEmail(String email);

    void sendPasswordResetEmail(String email);

    void signOut();
}
