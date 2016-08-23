package de.tomgrill.gdxfirebase.android.database;


import com.google.firebase.database.DatabaseError;
import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

import java.util.Map;

public class AndroidDatabaseReference extends AndroidQuery implements DatabaseReference {

    private com.google.firebase.database.DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    public AndroidDatabaseReference(com.google.firebase.database.DatabaseReference databaseReference, FirebaseDatabase firebaseDatabase) {
        super(databaseReference);
        this.databaseReference = databaseReference;
        this.firebaseDatabase = firebaseDatabase;
    }

    @Override
    public DatabaseReference child(String s) {
        return new AndroidDatabaseReference(databaseReference.child(s), firebaseDatabase);
    }

    @Override
    public DatabaseReference push() {
        return new AndroidDatabaseReference(databaseReference.push(), firebaseDatabase);
    }

    @Override
    public String getKey() {
        return databaseReference.getKey();
    }

    @Override
    public void setValue(Object o) {
        databaseReference.setValue(o);
    }

    @Override
    public void setValue(Object value, Object priority) {
        databaseReference.setValue(value, priority);
    }

    @Override
    public void setValue(Object value, final CompletionListener listener) {
        databaseReference.setValue(value, new com.google.firebase.database.DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new AndroidDatabaseError(databaseError), new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                }
            }
        });
    }

    @Override
    public void setValue(Object value, Object priority, final CompletionListener listener) {
        databaseReference.setValue(value, priority, new com.google.firebase.database.DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new AndroidDatabaseError(databaseError), new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                }
            }
        });
    }

    @Override
    public void setPriority(Object priority) {
        databaseReference.setPriority(priority);
    }

    @Override
    public void setPriority(Object priority, final CompletionListener listener) {
        databaseReference.setPriority(priority, new com.google.firebase.database.DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new AndroidDatabaseError(databaseError), new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                }
            }
        });
    }

    @Override
    public void updateChildren(Map<String, Object> update) {
        databaseReference.updateChildren(update);
    }

    @Override
    public void updateChildren(Map<String, Object> update, final CompletionListener listener) {
        databaseReference.updateChildren(update, new com.google.firebase.database.DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new AndroidDatabaseError(databaseError), new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                }
            }
        });
    }

    @Override
    public void removeValue() {
        databaseReference.removeValue();
    }

    @Override
    public void removeValue(final CompletionListener listener) {
        databaseReference.removeValue(new com.google.firebase.database.DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new AndroidDatabaseError(databaseError), new AndroidDatabaseReference(databaseReference, firebaseDatabase));
                }
            }
        });
    }

    @Override
    public FirebaseDatabase getDatabase() {
        return firebaseDatabase;
    }

    @Override
    public DatabaseReference getParent() {
        return new AndroidDatabaseReference(databaseReference.getParent(), firebaseDatabase);
    }

    @Override
    public DatabaseReference getRoot() {
        return new AndroidDatabaseReference(databaseReference.getRoot(), firebaseDatabase);
    }

    @Override
    public String toString() {
        return databaseReference.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof AndroidDatabaseReference && databaseReference.equals(((AndroidDatabaseReference) o).databaseReference);
    }

    @Override
    public int hashCode() {
        return databaseReference.hashCode();
    }
}
