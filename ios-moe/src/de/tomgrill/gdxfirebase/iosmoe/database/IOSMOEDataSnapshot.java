package de.tomgrill.gdxfirebase.iosmoe.database;

import apple.foundation.NSDictionary;
import apple.foundation.NSNull;
import apple.foundation.NSNumber;
import apple.foundation.NSString;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Field;
import com.google.firebasedatabase.FIRDataSnapshot;
import de.tomgrill.gdxfirebase.core.database.DataSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        return castToProperValue(firDataSnapshot.value());
    }

    @Override
    public Object getValue(boolean useExportFormat) {
        if (useExportFormat) {
            throw new UnsupportedOperationException("useExportFormat is not supported");
        }
        return castToProperValue(firDataSnapshot.value());
    }

    private Object castToProperValue(Object object) {
        if (object instanceof NSNull) {
            return null;
        }

        if (object instanceof NSString) {
            return object.toString();
        }

        if (object instanceof String) {
            return object;
        }

        if (object instanceof NSNumber) {
            NSNumber nsNumber = (NSNumber) object;

            String cType = nsNumber.objCType();
            switch (cType) {
                case "c":
                    return nsNumber.boolValue();
                case "i":
                    return nsNumber.integerValue();
                case "q":
                    return nsNumber.longValue();
                case "f":
                    return nsNumber.floatValue();
                case "d":
                    return nsNumber.doubleValue();
                default:
                    return nsNumber.integerValue();
            }
        }

        if (object instanceof NSDictionary) {
            NSDictionary<String, Object> dictionary = (NSDictionary) object;
            Map<String, Object> map = new HashMap<String, Object>();
            for (Object key : dictionary.keySet()) {
                Object value = dictionary.get(key);
                map.put((String) key, castToProperValue(value));
            }
            return map;
        }

        throw new UnsupportedOperationException("cannot cast to proper value: " + object + " " + object.getClass());
    }

    @Override
    public <T> T getValue(Class<T> valueType) {

        if (firDataSnapshot.value() instanceof NSNull) {
            return null;
        }

        Object value = firDataSnapshot.value();

        if (value instanceof NSNumber) {
            return valueType.cast(castToProperValue(value));
        }

        if (value instanceof NSString && valueType == String.class) {
            return valueType.cast(value);
        }

        // special classes


        try {
            Object instance = ClassReflection.getConstructor(valueType).newInstance();

            Field[] fields = ClassReflection.getFields(valueType);
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];

                if (field.isPublic()) {

                    NSDictionary<String, Object> dictionary = (NSDictionary) firDataSnapshot.value();
                    for (Object key : dictionary.keySet()) {
                        Object dictValue = dictionary.get(key);

                        if (field.getName().equals(key)) {

                            if (field.getType() == Integer.class || field.getType() == Integer.TYPE) {
                                field.set(instance, ((NSNumber) dictValue).intValue());
                                break;
                            }

                            if (field.getType() == Long.class || field.getType() == Long.TYPE) {
                                field.set(instance, ((NSNumber) dictValue).longValue());
                                break;
                            }

                            if (field.getType() == Float.class || field.getType() == Float.TYPE) {
                                field.set(instance, ((NSNumber) dictValue).floatValue());
                                break;
                            }

                            if (field.getType() == Double.class || field.getType() == Double.TYPE) {
                                field.set(instance, ((NSNumber) dictValue).doubleValue());
                                break;
                            }

                            if (field.getType() == Boolean.class || field.getType() == Boolean.TYPE) {
                                field.set(instance, ((NSNumber) dictValue).boolValue());
                                break;
                            }

                            if (field.getType() == String.class) {
                                field.set(instance, dictValue.toString());
                                break;
                            }
                        }
                    }
                }

            }

            return valueType.cast(instance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("This class cannot be reflected: " + valueType);
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

    @Override
    public String toString() {
        return firDataSnapshot.value().toString();
    }
}
