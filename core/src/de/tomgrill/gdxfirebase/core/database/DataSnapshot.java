package de.tomgrill.gdxfirebase.core.database;

public interface DataSnapshot {

    DataSnapshot child(String path);

    boolean hasChild(String path);

    boolean hasChildren();

    boolean exists();

    Object getValue();

    Object getValue(boolean useExportFormat);

    <T> T getValue(Class<T> valueType);

//    <T> T getValue(GenericTypeIndicator<T> t); TODO

    long getChildrenCount();

//    DatabaseReference getRef(); TODO

    String getKey();

    Iterable<DataSnapshot> getChildren();

    Object getPriority();

    String toString();
}
