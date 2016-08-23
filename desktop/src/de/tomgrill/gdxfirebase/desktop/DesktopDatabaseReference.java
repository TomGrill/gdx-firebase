package de.tomgrill.gdxfirebase.desktop;

import de.tomgrill.gdxfirebase.core.DatabaseReference;
import de.tomgrill.gdxfirebase.core.FirebaseDatabase;

import java.util.Map;

public class DesktopDatabaseReference extends DesktopQuery implements DatabaseReference {
    private com.google.firebase.database.DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;


    DesktopDatabaseReference(com.google.firebase.database.DatabaseReference databaseReference, FirebaseDatabase firebaseDatabase) {
        super(databaseReference);
        this.databaseReference = databaseReference;
        this.firebaseDatabase = firebaseDatabase;
    }

    @Override
    public DatabaseReference child(String s) {
        return new DesktopDatabaseReference(databaseReference.child(s), firebaseDatabase);
    }

    @Override
    public DatabaseReference push() {
        return new DesktopDatabaseReference(databaseReference.push(), firebaseDatabase);
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
            public void onComplete(com.google.firebase.database.DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new DesktopDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new DesktopDatabaseError(databaseError), new DesktopDatabaseReference(databaseReference, firebaseDatabase));
                }
            }
        });
    }

    @Override
    public void setValue(Object value, Object priority, final CompletionListener listener) {
        databaseReference.setValue(value, priority, new com.google.firebase.database.DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(com.google.firebase.database.DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new DesktopDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new DesktopDatabaseError(databaseError), new DesktopDatabaseReference(databaseReference, firebaseDatabase));
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
            public void onComplete(com.google.firebase.database.DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new DesktopDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new DesktopDatabaseError(databaseError), new DesktopDatabaseReference(databaseReference, firebaseDatabase));
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
            public void onComplete(com.google.firebase.database.DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new DesktopDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new DesktopDatabaseError(databaseError), new DesktopDatabaseReference(databaseReference, firebaseDatabase));
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
            public void onComplete(com.google.firebase.database.DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference) {
                if (databaseError == null) {
                    listener.onComplete(null, new DesktopDatabaseReference(databaseReference, firebaseDatabase));
                } else {
                    listener.onComplete(new DesktopDatabaseError(databaseError), new DesktopDatabaseReference(databaseReference, firebaseDatabase));
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
        return new DesktopDatabaseReference(databaseReference.getParent(), firebaseDatabase);
    }

    @Override
    public DatabaseReference getRoot() {
        return new DesktopDatabaseReference(databaseReference.getRoot(), firebaseDatabase);
    }

    @Override
    public String toString() {
        return databaseReference.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof DesktopDatabaseReference && databaseReference.equals(((DesktopDatabaseReference) o).databaseReference);
    }

    @Override
    public int hashCode() {
        return databaseReference.hashCode();
    }
}
