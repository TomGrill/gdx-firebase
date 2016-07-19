package de.tomgrill.gdxfirebase.android;


import de.tomgrill.gdxfirebase.core.DatabaseError;

public class AndroidDatabaseError implements DatabaseError {

    public static final int DATA_STALE = -1;
    public static final int OPERATION_FAILED = -2;
    public static final int PERMISSION_DENIED = -3;
    public static final int DISCONNECTED = -4;
    public static final int EXPIRED_TOKEN = -6;
    public static final int INVALID_TOKEN = -7;
    public static final int MAX_RETRIES = -8;
    public static final int OVERRIDDEN_BY_SET = -9;
    public static final int UNAVAILABLE = -10;
    public static final int USER_CODE_EXCEPTION = -11;
    public static final int NETWORK_ERROR = -24;
    public static final int WRITE_CANCELED = -25;
    public static final int UNKNOWN_ERROR = -999;

    private com.google.firebase.database.DatabaseError databaseError;

    AndroidDatabaseError(com.google.firebase.database.DatabaseError databaseError) {
        this.databaseError = databaseError;
    }

    @Override
    public int getCode() {
        return databaseError.getCode();
    }

    @Override
    public String getMessage() {
        return databaseError.getMessage();
    }

    @Override
    public String getDetails() {
        return databaseError.getDetails();
    }

    @Override
    public String toString() {
        return databaseError.toString();
    }
}
