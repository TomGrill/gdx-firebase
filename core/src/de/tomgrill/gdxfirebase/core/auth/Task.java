package de.tomgrill.gdxfirebase.core.auth;

public interface Task<TResult> {
    boolean isComplete();

    boolean isSuccessful();

//    TResult getResult();

//    Task<TResult> addOnSuccessListener(OnSuccessListener<de.tomgrill.gdxfirebase.core.auth.AuthResult> var1);

    Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> var1);

//    Task<TResult> addOnFailureListener(OnFailureListener var1);

//    @Nullable
//    public abstract Exception getException();
//
//    @NonNull
//    public abstract Task<TResult> addOnSuccessListener(@NonNull Executor var1, @NonNull OnSuccessListener<? super TResult> var2);
//
//    @NonNull
//    public abstract Task<TResult> addOnSuccessListener(@NonNull Activity var1, @NonNull OnSuccessListener<? super TResult> var2);
//
//    @NonNull
//    public abstract Task<TResult> addOnFailureListener(@NonNull Executor var1, @NonNull OnFailureListener var2);
//
//    @NonNull
//    public abstract Task<TResult> addOnFailureListener(@NonNull Activity var1, @NonNull OnFailureListener var2);
//
//    @NonNull
//    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> var1) {
//        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
//    }
//
//    @NonNull
//    public Task<TResult> addOnCompleteListener(@NonNull Executor var1, @NonNull OnCompleteListener<TResult> var2) {
//        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
//    }
//
//    @NonNull
//    public Task<TResult> addOnCompleteListener(@NonNull Activity var1, @NonNull OnCompleteListener<TResult> var2) {
//        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
//    }
//
//    @NonNull
//    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> var1) {
//        throw new UnsupportedOperationException("continueWith is not implemented");
//    }
//
//    @NonNull
//    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor var1, @NonNull Continuation<TResult, TContinuationResult> var2) {
//        throw new UnsupportedOperationException("continueWith is not implemented");
//    }
//
//    @NonNull
//    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> var1) {
//        throw new UnsupportedOperationException("continueWithTask is not implemented");
//    }
//
//    @NonNull
//    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor var1, @NonNull Continuation<TResult, Task<TContinuationResult>> var2) {
//        throw new UnsupportedOperationException("continueWithTask is not implemented");
//    }
}
