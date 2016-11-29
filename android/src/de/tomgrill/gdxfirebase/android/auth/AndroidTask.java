package de.tomgrill.gdxfirebase.android.auth;

import android.support.annotation.NonNull;
import com.google.firebase.auth.AuthResult;
import de.tomgrill.gdxfirebase.core.auth.OnCompleteListener;
import de.tomgrill.gdxfirebase.core.auth.Task;

public class AndroidTask<TResult> implements Task<TResult> {
    private com.google.android.gms.tasks.Task<AuthResult> authResultTask;

    public AndroidTask(com.google.android.gms.tasks.Task<AuthResult> authResultTask) {
        this.authResultTask = authResultTask;
    }

    @Override
    public boolean isComplete() {
        return authResultTask.isComplete();
    }

    @Override
    public boolean isSuccessful() {
        return authResultTask.isSuccessful();
    }

    @Override
    public Task<TResult> addOnCompleteListener(final OnCompleteListener<TResult> completeListener) {
        authResultTask.addOnCompleteListener(new com.google.android.gms.tasks.OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                completeListener.onComplete(new AndroidTask<TResult>(task));
            }
        });
        return this;
    }

//    @Override
//    public Task<TResult> addOnSuccessListener(final OnSuccessListener<de.tomgrill.gdxfirebase.core.auth.AuthResult> var1) {
//        this.authResultTask.addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<AuthResult>() {
//            @Override
//            public void onSuccess(AuthResult authResult) {
//                var1.onSuccess(new AndroidAuthResult(authResult));
//            }
//        });
//        return this;
//    }
}
