package com.db.campus.property.enums;

public enum Role {

    ADMIN("Админ"),
    ACCOUNTANT("Бухгалтер"),
    WORKER("Работник университета"),
    OFFICER("Служащий хоз. части");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
