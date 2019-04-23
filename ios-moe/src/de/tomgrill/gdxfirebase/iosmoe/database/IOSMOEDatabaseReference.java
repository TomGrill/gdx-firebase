package de.tomgrill.gdxfirebase.iosmoe.database;

import apple.foundation.*;
import com.google.firebasedatabase.FIRDatabase;
import com.google.firebasedatabase.FIRDatabaseReference;
import com.google.firebasedatabase.FIRServerValue;
import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;
import de.tomgrill.gdxfirebase.core.database.ServerValue;

import java.util.List;
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
        firDatabaseReference.setValue(makeFirebaseCompatibleObject(value));
    }

    @Override
    public void setValue(Object value, Object priority) {
        firDatabaseReference.setValueAndPriority(makeFirebaseCompatibleObject(value), priority);
    }

    @Override
    public void setValue(Object value, final CompletionListener listener) {
        firDatabaseReference.setValueWithCompletionBlock(makeFirebaseCompatibleObject(value), new FIRDatabaseReference.Block_setValueWithCompletionBlock() {
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
        firDatabaseReference.setValueAndPriorityWithCompletionBlock(makeFirebaseCompatibleObject(value), priority, new FIRDatabaseReference.Block_setValueAndPriorityWithCompletionBlock() {
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
        firDatabaseReference.updateChildValues(toDictionary(update));
    }


    @Override
    public void updateChildren(Map<String, Object> update,final CompletionListener listener) {
        firDatabaseReference.updateChildValuesWithCompletionBlock(toDictionary(update), new FIRDatabaseReference.Block_updateChildValuesWithCompletionBlock() {
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

    private Object makeFirebaseCompatibleObject(Object object) {
        if (object == ServerValue.TIMESTAMP) {
            return FIRServerValue.timestamp();
        }

        if (object == null) {
            return NSNull.alloc().init();
        }

        if (object instanceof Map) {
            return toDictionary((Map) object);
        }

        if (object instanceof List) {
            throw new UnsupportedOperationException("List is not yet supported");
        }

        if (object instanceof Integer) {
            return NSNumber.numberWithInt((Integer) object);
        }

        if (object instanceof Long) {
            return NSNumber.numberWithLong((Long) object);
        }

        if (object instanceof Float) {
            return NSNumber.numberWithFloat((Float) object);
        }

        if (object instanceof Double) {
            return NSNumber.numberWithDouble((Double) object);
        }

        if (object instanceof String) {
            return NSString.stringWithString((String) object);
        }

        if (object instanceof Boolean) {
            return NSNumber.numberWithBool((Boolean) object);
        }
        throw new UnsupportedOperationException("Unsupported object type: " + object.getClass());
    }

    private NSDictionary<NSString, Object> toDictionary(Map<String, Object> map) {
        NSMutableDictionary<NSString, Object> dictionary = (NSMutableDictionary<NSString, Object>) NSMutableDictionary.dictionary();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            dictionary.put(NSString.stringWithString(entry.getKey()), makeFirebaseCompatibleObject(entry.getValue()));
        }


        return dictionary;
    }

    @Override
    public void removeValue() {
        firDatabaseReference.removeValue();
    }

    @Override
    public void removeValue(final CompletionListener listener) {
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
        return new IOSMOEFirebaseDatabase();
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
