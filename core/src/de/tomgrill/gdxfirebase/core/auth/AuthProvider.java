package de.tomgrill.gdxfirebase.core.auth;

public interface AuthProvider {

    AuthCredential getCredentials();

    String getProviderId();
}
