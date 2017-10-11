package de.tomgrill.gdxfirebase.iosmoe.database;

import apple.foundation.NSError;
import de.tomgrill.gdxfirebase.core.database.DatabaseError;

public class IOSMOEDatabaseError implements DatabaseError {

    private final NSError error;

    public IOSMOEDatabaseError(NSError error) {
        this.error = error;
    }

    @Override
    public int getCode() {
        return (int) error.code();
    }

    @Override
    public String getMessage() {
        return error.localizedFailureReason();
    }

    @Override
    public String getDetails() {
        return error.localizedRecoverySuggestion();
    }
}
