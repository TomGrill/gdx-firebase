package de.tomgrill.gdxfirebase.iosmoe.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthResult;
import de.tomgrill.gdxfirebase.core.auth.OnCompleteListener;
import de.tomgrill.gdxfirebase.core.auth.Task;

public class IOSMOETask<TResult> implements Task<TResult> {

    private final boolean complete;
    private final boolean successful;
    private Exception exception;

    public IOSMOETask(boolean complete, boolean successful, Exception exception) {
        this.complete = complete;
        this.successful = successful;
        this.exception = exception;
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
        // not used on IOS
        return this;
    }

    @Override
    public Exception getException() {
        return exception;
    }
}
