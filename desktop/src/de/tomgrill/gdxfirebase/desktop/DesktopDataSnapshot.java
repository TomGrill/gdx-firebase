package de.tomgrill.gdxfirebase.desktop;


import com.badlogic.gdx.utils.Array;
import de.tomgrill.gdxfirebase.core.DataSnapshot;

import java.util.ArrayList;

public class DesktopDataSnapshot implements DataSnapshot {

    private com.google.firebase.database.DataSnapshot dataSnapshot;

    public DesktopDataSnapshot(com.google.firebase.database.DataSnapshot dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
    }

    @Override
    public DataSnapshot child(String path) {
        return new DesktopDataSnapshot(dataSnapshot.child(path));
    }

    @Override
    public boolean hasChild(String path) {
        return dataSnapshot.hasChild(path);
    }

    @Override
    public boolean hasChildren() {
        return dataSnapshot.hasChildren();
    }

    @Override
    public boolean exists() {
        return dataSnapshot.exists();
    }

    @Override
    public Object getValue() {
        return dataSnapshot.getValue();
    }

    @Override
    public Object getValue(boolean useExportFormat) {
        return dataSnapshot.getValue(useExportFormat);
    }

    @Override
    public <T> T getValue(Class<T> valueType) {
        return dataSnapshot.getValue(valueType);
    }

    @Override
    public long getChildrenCount() {
        return dataSnapshot.getChildrenCount();
    }


    @Override
    public String getKey() {
        return dataSnapshot.getKey();
    }

    @Override
    public Iterable<DataSnapshot> getChildren() {
        Array<DataSnapshot> resultIterable = new Array<>();
        for (com.google.firebase.database.DataSnapshot dataSnapshot : this.dataSnapshot.getChildren()) {
            resultIterable.add(new DesktopDataSnapshot(dataSnapshot));
        }
        return resultIterable;
    }

    @Override
    public Object getPriority() {
        return dataSnapshot.getPriority();
    }

    @Override
    public String toString() {
        String var1 = String.valueOf(this.getKey());
        String var2 = String.valueOf(this.getValue(true));
        return (new StringBuilder(33 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("DataSnapshot { key = ").append(var1).append(", value = ").append(var2).append(" }").toString();

    }
}
