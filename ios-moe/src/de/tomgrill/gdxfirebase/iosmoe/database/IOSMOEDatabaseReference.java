package de.tomgrill.gdxfirebase.iosmoe.database;

import apple.foundation.NSError;
import apple.foundation.NSMutableDictionary;
import com.google.firebasedatabase.FIRDatabase;
import com.google.firebasedatabase.FIRDatabaseReference;
import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;

import java.util.Map;

public class IOSMOEDatabaseReference extends IOSMOEQuery implements DatabaseReference {

    private FIRDatabaseReference firDatabaseReference;
    private FIRDatabase firDatabase;

    public IOSMOEDatabaseReference(FIRDatabaseReference firDatabaseReference, FIRDatabase firDatabase) {
        super(firDatabaseReference);
        this.firDatabaseReference = firDatabaseReference;
        this.firDatabase = firDatabase;
    }

    @Override
    public DatabaseReference child(String s) {
        return new IOSMOEDatabaseReference(firDatabaseReference.child(s), firDatabase);
    }

    @Override
    public DatabaseReference push() {
        return new IOSMOEDatabaseReference(firDatabaseReference.childByAutoId(), firDatabase);
    }

    @Override
    public void setValue(Object value) {
        firDatabaseReference.setValue(value);
    }

    @Override
    public void setValue(Object value, Object priority) {
        firDatabaseReference.setValueAndPriority(value, priority);
    }

    @Override
    public void setValue(Object value, final CompletionListener listener) {
        firDatabaseReference.setValueWithCompletionBlock(value, new FIRDatabaseReference.Block_setValueWithCompletionBlock() {
            @Override
            public void call_setValueWithCompletionBlock(NSError error, FIRDatabaseReference databaseReference) {
                if (error == null) {
                    listener.onComplete(null, new IOSMOEDatabaseReference(databaseReference, firDatabase));
                } else {
                    listener.onComplete(new IOSMOEDatabaseError(error), new IOSMOEDatabaseReference(databaseReference, firDatabase));
                }
            }
        });
    }

    @Override
    public void setValue(Object value, Object priority, final CompletionListener listener) {
        firDatabaseReference.setValueAndPriorityWithCompletionBlock(value, priority, new FIRDatabaseReference.Block_setValueAndPriorityWithCompletionBlock() {
            @Override
            public void call_setValueAndPriorityWithCompletionBlock(NSError error, FIRDatabaseReference databaseReference) {
                if (error == null) {
                    listener.onComplete(null, new IOSMOEDatabaseReference(databaseReference, firDatabase));
                } else {
                    listener.onComplete(new IOSMOEDatabaseError(error), new IOSMOEDatabaseReference(databaseReference, firDatabase));
                }
            }
        });
    }

    @Override
    public void setPriority(Object priority) {
        firDatabaseReference.setPriority(priority);
    }

    @Override
    public void setPriority(Object priority, final CompletionListener listener) {
        firDatabaseReference.setPriorityWithCompletionBlock(priority, new FIRDatabaseReference.Block_setPriorityWithCompletionBlock() {
            @Override
            public void call_setPriorityWithCompletionBlock(NSError error, FIRDatabaseReference databaseReference) {
                if (error == null) {
                    listener.onComplete(null, new IOSMOEDatabaseReference(databaseReference, firDatabase));
                } else {
                    listener.onComplete(new IOSMOEDatabaseError(error), new IOSMOEDatabaseReference(databaseReference, firDatabase));
                }
            }
        });
    }

    @Override
    public void updateChildren(Map<String, Object> update) {
        NSMutableDictionary<String, Object> dictionary = NSMutableDictionary.dictionaryWithSharedKeySet(update);
        firDatabaseReference.updateChildValues(dictionary);
    }

    @Override
    public void updateChildren(Map<String, Object> update, CompletionListener listener) {
        NSMutableDictionary<String, Object> dictionary = NSMutableDictionary.dictionaryWithSharedKeySet(update);
        firDatabaseReference.updateChildValuesWithCompletionBlock(dictionary, new FIRDatabaseReference.Block_updateChildValuesWithCompletionBlock() {
            @Override
            public void call_updateChildValuesWithCompletionBlock(NSError error, FIRDatabaseReference databaseReference) {
                if (error == null) {
                    listener.onComplete(null, new IOSMOEDatabaseReference(databaseReference, firDatabase));
                } else {
                    listener.onComplete(new IOSMOEDatabaseError(error), new IOSMOEDatabaseReference(databaseReference, firDatabase));
                }
            }
        });
    }

    @Override
    public void removeValue() {
        firDatabaseReference.removeValue();
    }

    @Override
    public void removeValue(CompletionListener listener) {
        firDatabaseReference.removeValueWithCompletionBlock(new FIRDatabaseReference.Block_removeValueWithCompletionBlock() {
            @Override
            public void call_removeValueWithCompletionBlock(NSError error, FIRDatabaseReference databaseReference) {
                if (error == null) {
                    listener.onComplete(null, new IOSMOEDatabaseReference(databaseReference, firDatabase));
                } else {
                    listener.onComplete(new IOSMOEDatabaseError(error), new IOSMOEDatabaseReference(databaseReference, firDatabase));
                }
            }
        });
    }

    @Override
    public FirebaseDatabase getDatabase() {
        return new IOSMOEFirebaseDatabase(firDatabase);
    }

    @Override
    public DatabaseReference getParent() {
        return new IOSMOEDatabaseReference(firDatabaseReference.parent(), firDatabase);
    }

    @Override
    public DatabaseReference getRoot() {
        return new IOSMOEDatabaseReference(firDatabaseReference.root(), firDatabase);
    }

    @Override
    public String getKey() {
        return firDatabaseReference.key();
    }
}
