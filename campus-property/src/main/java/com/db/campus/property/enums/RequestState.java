package com.db.campus.property.enums;

public enum RequestState {

    WAITING("Отправлено на обработку"),
    PROCESSING("Обрабатывается"),
    READY("Готово");

    private final String displayName;

    RequestState(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
