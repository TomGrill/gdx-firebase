package de.tomgrill.gdxfirebase.android.auth;

import de.tomgrill.gdxfirebase.core.auth.AuthResult;


public class AndroidAuthResult implements AuthResult {

    private com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> task;

    public AndroidAuthResult(com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> task) {
        this.task = task;
    }

    @Override
    public boolean isSuccessful() {
        return task.isSuccessful();
    }

//    @Override
//    public FirebaseUser getUser() {
//        return null;
//    }
}
