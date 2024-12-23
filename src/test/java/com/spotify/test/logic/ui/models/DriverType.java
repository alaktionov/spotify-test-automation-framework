package com.spotify.test.logic.ui.models;

import java.util.Arrays;

public enum DriverType {
    CHROME("chrome"),
    SAFARI("safari"),
    IE("ie"),
    FIREFOX("firefox");

    private final String value;

    DriverType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static DriverType getDriverType(String value) {
        return Arrays.stream(DriverType.values())
            .filter(type -> type.value.equals(value))
            .findFirst()
            .orElseThrow();
    }
}
