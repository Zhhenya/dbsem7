package com.db.campus.property.enums;

public enum ObjectState {

    REPAIRING("Ремонт"),
    WORKING("Рабочее состояние"),
    CANCELLED("Списан");

    private final String displayName;

    ObjectState(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
