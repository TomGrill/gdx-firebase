package de.tomgrill.gdxfirebase.iosmoe.database;

import apple.NSObject;
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
    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1> block1Listeners = new Array<>();
    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2> block2Listeners = new Array<>();

    private Array<ChildEventListener> childEventListeners = new Array<>();
    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1> addedBlocks = new Array<>();
    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2> addedCancels = new Array<>();

    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1> changedBlocks = new Array<>();
    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2> changedCancels = new Array<>();

    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1> movedBlocks = new Array<>();
    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2> movedCancels = new Array<>();

    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_1> removedBlocks = new Array<>();
    private Array<FIRDatabaseQuery.Block_observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock_2> removedCancels = new Array<>();

    public IOSMOEQuery(FIRDatabaseQuery firDatabaseQuery) {
        this.firDatabaseQuery = firDatabaseQuery;
    }

    @Override
    public ValueEventListener addValueEventListener(ValueEventListener listener) {

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


        firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.Value, block1Listener, block2Listener);

        valueEventListeners.add(listener);
        block1Listeners.add(block1Listener);
        block2Listeners.add(block2Listener);

        return listener;
    }

    @Override
    public ChildEventListener addChildEventListener(ChildEventListener listener) {

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


            firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildAdded, block, cancel);
            addedBlocks.add(block);
            addedCancels.add(cancel);
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


            firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildChanged, block, cancel);
            changedBlocks.add(block);
            changedCancels.add(cancel);
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


            firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildMoved, block, cancel);
            movedBlocks.add(block);
            movedCancels.add(cancel);
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


            firDatabaseQuery.observeEventTypeAndPreviousSiblingKeyWithBlockWithCancelBlock(FIRDataEventType.ChildRemoved, block, cancel);
            removedBlocks.add(block);
            removedCancels.add(cancel);
        }


        childEventListeners.add(listener);


        return listener;
    }

    @Override
    public void addListenerForSingleValueEvent(ValueEventListener listener) {
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
            firDatabaseQuery.removeObserverForKeyPath((NSObject) block1Listeners.get(index), firDatabaseQuery.ref().key());
            firDatabaseQuery.removeObserverForKeyPath((NSObject) block2Listeners.get(index), firDatabaseQuery.ref().key());
            block1Listeners.removeIndex(index);
            block2Listeners.removeIndex(index);
            valueEventListeners.removeIndex(index);
        }
    }

    @Override
    public void removeEventListener(ChildEventListener listener) {
        int index = childEventListeners.indexOf(listener, true);
        if (index != -1) {
            String keyPath = firDatabaseQuery.ref().key();
            firDatabaseQuery.removeObserverForKeyPath((NSObject) addedBlocks.get(index), keyPath);
            firDatabaseQuery.removeObserverForKeyPath((NSObject) addedCancels.get(index), keyPath);
            firDatabaseQuery.removeObserverForKeyPath((NSObject) changedBlocks.get(index), keyPath);
            firDatabaseQuery.removeObserverForKeyPath((NSObject) changedCancels.get(index), keyPath);
            firDatabaseQuery.removeObserverForKeyPath((NSObject) removedBlocks.get(index), keyPath);
            firDatabaseQuery.removeObserverForKeyPath((NSObject) removedCancels.get(index), keyPath);
            firDatabaseQuery.removeObserverForKeyPath((NSObject) movedBlocks.get(index), keyPath);
            firDatabaseQuery.removeObserverForKeyPath((NSObject) movedCancels.get(index), keyPath);

            addedBlocks.removeIndex(index);
            addedCancels.removeIndex(index);

            changedBlocks.removeIndex(index);
            changedCancels.removeIndex(index);

            removedBlocks.removeIndex(index);
            removedCancels.removeIndex(index);

            movedBlocks.removeIndex(index);
            movedCancels.removeIndex(index);

            valueEventListeners.removeIndex(index);
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
