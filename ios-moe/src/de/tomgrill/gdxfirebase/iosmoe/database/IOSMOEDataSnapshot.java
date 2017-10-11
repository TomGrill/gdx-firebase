package de.tomgrill.gdxfirebase.iosmoe.database;

import apple.foundation.NSNull;
import apple.foundation.NSNumber;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.google.firebasedatabase.FIRDataSnapshot;
import de.tomgrill.gdxfirebase.core.database.DataSnapshot;

import java.util.ArrayList;

public class IOSMOEDataSnapshot implements DataSnapshot {

    private FIRDataSnapshot firDataSnapshot;

    public IOSMOEDataSnapshot(FIRDataSnapshot firDataSnapshot) {
        this.firDataSnapshot = firDataSnapshot;
    }

    @Override
    public DataSnapshot child(String path) {
        return new IOSMOEDataSnapshot(firDataSnapshot.childSnapshotForPath(path));
    }

    @Override
    public boolean hasChild(String path) {
        return firDataSnapshot.hasChild(path);
    }

    @Override
    public boolean hasChildren() {
        return firDataSnapshot.hasChildren();
    }

    @Override
    public boolean exists() {
        return firDataSnapshot.exists();
    }

    @Override
    public Object getValue() {
        if(firDataSnapshot.value() instanceof  NSNull) {
            return null;
        }
        return firDataSnapshot.value();
    }

    @Override
    public Object getValue(boolean useExportFormat) {
        if(firDataSnapshot.value() instanceof  NSNull) {
            return null;
        }
        if (useExportFormat) {
            return firDataSnapshot.valueInExportFormat();
        }
        return getValue();
    }

    @Override
    public <T> T getValue(Class<T> valueType) {

        if(firDataSnapshot.value() instanceof  NSNull) {
            return null;
        }

        Object value = firDataSnapshot.value();
        if(value instanceof NSNumber && valueType == Long.class) {
            System.out.println("C LONG");
            return valueType.cast(((NSNumber) value).longValue());
        }

        if(value instanceof NSNumber && valueType == Boolean.class) {
            System.out.println("C BOOLEAN " + ((NSNumber) value).longValue());
            if(((NSNumber) value).longValue() == 0) {
                return valueType.cast(false);
            }
            return valueType.cast(true);
        }


        System.out.println(firDataSnapshot.value());
        System.out.println(firDataSnapshot.value().getClass());


        //throw new UnsupportedOperationException("NYI");
        return (T) firDataSnapshot.value();
    }

    @Override
    public long getChildrenCount() {
        return firDataSnapshot.childrenCount();
    }

    @Override
    public String getKey() {
        return firDataSnapshot.key();
    }

    @Override
    public Iterable<DataSnapshot> getChildren() {

        ArrayList<DataSnapshot> list = new ArrayList<>();

        for (int i = 0; i < firDataSnapshot.childrenCount(); i++) {
            FIRDataSnapshot o = (FIRDataSnapshot) firDataSnapshot.children().allObjects().get(i);
            list.add(new IOSMOEDataSnapshot(o));

        }

        return list;
    }

    @Override
    public Object getPriority() {
        return firDataSnapshot.priority();
    }
}
