package de.tomgrill.gdxfirebase.core.auth;

public class GdxFirebaseException extends Exception {
    public GdxFirebaseException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return GdxFirebaseException.class.getSuperclass() + " " + super.getMessage();
    }
}
