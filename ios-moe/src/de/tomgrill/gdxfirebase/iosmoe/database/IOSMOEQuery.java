package de.tomgrill.gdxfirebase.iosmoe.database;


import apple.foundation.NSError;
import com.badlogic.gdx.utils.Array;
import com.google.firebasedatabase.FIRDataSnapshot;
import com.google.firebasedatabase.FIRDatabaseQuery;
import com.google.firebasedatabase.enums.FIRDataEventType;
import de.tomgrill.gdxfirebase.core.database.ChildEventListener;
import de.tomgrill.gdxfirebase.core.database.Query;
import de.tomgrill.gdxfirebase.core.database.ValueEventListener;

public class IOSMOEQuery implements Query {

    private FIRDatabaseQuery firDatabaseQuery;

    private Array<ValueEventListener> valueEventListeners = new Array<>();

    private Array<ChildEventListener> childEventListeners = new Array<>();

    private Array<Long> valueHandles = new Array<>();

    private Array<Long> addChildHandles = new Array<>();
    private Array<Long> changedChildHandles = new Array<>();
    private Array<Long> movedChildHandles = new Array<>();
    private Array<Long> removedChildHandles = new Array<>();

    public IOSMOEQuery(FIRDatabaseQuery firDatabaseQuery) {
        this.firDatabaseQuery = firDatabaseQuery;
    }

    @Override
    public ValueEventListener addValueEventListener(final ValueEventListener listener) {

        FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1 block1Listener = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1() {
            @Override
            public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1(FIRDataSnapshot dataSnapshot, String arg1) {
                listener.onDataChange(new IOSMOEDataSnapshot(dataSnapshot));
            }
        };

        FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2 block2Listener = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2() {

            @Override
            public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2(NSError error) {
                listener.onCancelled(new IOSMOEDatabaseError(error));
            }
        };


        long handle = firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.Value, block1Listener, block2Listener);

        valueEventListeners.add(listener);
        valueHandles.add(handle);


        return listener;
    }

    @Override
    public ChildEventListener addChildEventListener(final ChildEventListener listener) {

        /*
        ADDED
         */
        {
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1 block = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1(FIRDataSnapshot dataSnapshot, String s) {
                    listener.onChildAdded(new IOSMOEDataSnapshot(dataSnapshot), s);
                }
            };
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2 cancel = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2(NSError error) {
                    listener.onCancelled(new IOSMOEDatabaseError(error));
                }
            };


            long handle = firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildAdded, block, cancel);
            addChildHandles.add(handle);
        }

        /*
        CHANGED
         */
        {
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1 block = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1(FIRDataSnapshot dataSnapshot, String s) {
                    listener.onChildChanged(new IOSMOEDataSnapshot(dataSnapshot), s);
                }
            };
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2 cancel = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2(NSError error) {
                    listener.onCancelled(new IOSMOEDatabaseError(error));
                }
            };


            long handle = firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildChanged, block, cancel);
            changedChildHandles.add(handle);
        }

        /*
        MOVED
         */
        {
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1 block = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1(FIRDataSnapshot dataSnapshot, String s) {
                    listener.onChildMoved(new IOSMOEDataSnapshot(dataSnapshot), s);
                }
            };
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2 cancel = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2(NSError error) {
                    listener.onCancelled(new IOSMOEDatabaseError(error));
                }
            };


            long handle = firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildMoved, block, cancel);
            movedChildHandles.add(handle);
        }

        /*
        REMOVED
         */
        {
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1 block = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1(FIRDataSnapshot dataSnapshot, String s) {
                    listener.onChildRemoved(new IOSMOEDataSnapshot(dataSnapshot));
                }
            };
            FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2 cancel = new FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2() {
                @Override
                public void call_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2(NSError error) {
                    listener.onCancelled(new IOSMOEDatabaseError(error));
                }
            };


            long handle = firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildRemoved, block, cancel);
            removedChildHandles.add(handle);
        }


        childEventListeners.add(listener);


        return listener;
    }

    @Override
    public void addListenerForSingleValueEvent(final ValueEventListener listener) {
        firDatabaseQuery.observeSingleEventOfTypeWithBlockWithCancelBlock(FIRDataEventType.Value, new FIRDatabaseQuery.Block_observeSingleEventOfTypeWithBlockWithCancelBlock_1() {
            @Override
            public void call_observeSingleEventOfTypeWithBlockWithCancelBlock_1(FIRDataSnapshot dataSnapshot) {
                listener.onDataChange(new IOSMOEDataSnapshot(dataSnapshot));
            }
        }, new FIRDatabaseQuery.Block_observeSingleEventOfTypeWithBlockWithCancelBlock_2() {
            @Override
            public void call_observeSingleEventOfTypeWithBlockWithCancelBlock_2(NSError error) {
                listener.onCancelled(new IOSMOEDatabaseError(error));
            }
        });
    }

    @Override
    public void removeEventListener(ValueEventListener listener) {
        int index = valueEventListeners.indexOf(listener, true);
        if (index != -1) {
            firDatabaseQuery.removeObserverWithHandle(valueHandles.get(index));
            valueHandles.removeIndex(index);
            valueEventListeners.removeIndex(index);
        }
    }

    @Override
    public void removeEventListener(ChildEventListener listener) {
        int index = childEventListeners.indexOf(listener, true);
        if (index != -1) {

            firDatabaseQuery.removeObserverWithHandle(addChildHandles.get(index));
            firDatabaseQuery.removeObserverWithHandle(changedChildHandles.get(index));
            firDatabaseQuery.removeObserverWithHandle(movedChildHandles.get(index));
            firDatabaseQuery.removeObserverWithHandle(removedChildHandles.get(index));

            addChildHandles.removeIndex(index);
            changedChildHandles.removeIndex(index);
            movedChildHandles.removeIndex(index);
            removedChildHandles.removeIndex(index);

            childEventListeners.removeIndex(index);
        }
    }

    @Override
    public void keepSynced(boolean keepSynced) {
        firDatabaseQuery.keepSynced(keepSynced);
    }

    @Override
    public Query startAt(String value) {
        return new IOSMOEQuery(firDatabaseQuery.queryStartingAtValue(value));
    }

    @Override
    public Query startAt(double value) {
        return new IOSMOEQuery(firDatabaseQuery.queryStartingAtValue(value));
    }

    @Override
    public Query startAt(boolean value) {
        return new IOSMOEQuery(firDatabaseQuery.queryStartingAtValue(value));
    }

    @Override
    public Query startAt(String value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryStartingAtValueChildKey(value, key));
    }

    @Override
    public Query startAt(double value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryStartingAtValueChildKey(value, key));
    }

    @Override
    public Query startAt(boolean value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryStartingAtValueChildKey(value, key));
    }

    @Override
    public Query endAt(String value) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValue(value));
    }

    @Override
    public Query endAt(double value) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValue(value));
    }

    @Override
    public Query endAt(boolean value) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValue(value));
    }

    @Override
    public Query endAt(String value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValueChildKey(value, key));
    }

    @Override
    public Query endAt(double value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValueChildKey(value, key));
    }

    @Override
    public Query endAt(boolean value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValueChildKey(value, key));
    }

    @Override
    public Query equalTo(String value) {
        return new IOSMOEQuery(firDatabaseQuery.queryEqualToValue(value));
    }

    @Override
    public Query equalTo(double value) {
        return new IOSMOEQuery(firDatabaseQuery.queryEqualToValue(value));
    }

    @Override
    public Query equalTo(boolean value) {
        return new IOSMOEQuery(firDatabaseQuery.queryEqualToValue(value));
    }

    @Override
    public Query equalTo(String value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValueChildKey(value, key));
    }

    @Override
    public Query equalTo(double value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValueChildKey(value, key));
    }

    @Override
    public Query equalTo(boolean value, String key) {
        return new IOSMOEQuery(firDatabaseQuery.queryEndingAtValueChildKey(value, key));
    }

    @Override
    public Query limitToFirst(int limit) {
        return new IOSMOEQuery(firDatabaseQuery.queryLimitedToFirst(limit));
    }

    @Override
    public Query limitToLast(int limit) {
        return new IOSMOEQuery(firDatabaseQuery.queryLimitedToFirst(limit));
    }

    @Override
    public Query orderByChild(String path) {
        return new IOSMOEQuery(firDatabaseQuery.queryOrderedByChild(path));
    }

    @Override
    public Query orderByPriority() {
        return new IOSMOEQuery(firDatabaseQuery.queryOrderedByPriority());
    }

    @Override
    public Query orderByKey() {
        return new IOSMOEQuery(firDatabaseQuery.queryOrderedByKey());
    }

    @Override
    public Query orderByValue() {
        return new IOSMOEQuery(firDatabaseQuery.queryOrderedByValue());
    }
}
