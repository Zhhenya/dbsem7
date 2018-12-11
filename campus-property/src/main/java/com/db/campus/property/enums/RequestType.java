package com.db.campus.property.enums;

public enum RequestType {

    NEW("Покупка нового"),
    REPAIR("Ремонт"),
    REPLACEMENT("Замена"),
    CANCELLATION("Списание");

    private final String displayName;

    RequestType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}

