package de.tomgrill.gdxfirebase.desktop.auth;

import de.tomgrill.gdxfirebase.core.auth.GdxFirebaseException;
import de.tomgrill.gdxfirebase.core.auth.OnCompleteListener;
import de.tomgrill.gdxfirebase.core.auth.Task;

public class DesktopTask<TResult> implements Task<TResult> {

    private final boolean complete;
    private final boolean successful;

    public DesktopTask(boolean complete, boolean successful) {
        this.complete = complete;
        this.successful = successful;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public boolean isSuccessful() {
        return successful;
    }

    @Override
    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> var1) {
        return null;
    }

    @Override
    public Exception getException() {
        return new GdxFirebaseException("desktop exception");
    }
}
