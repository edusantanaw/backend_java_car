package com.wswork.cars.domain.enums;

public enum Fuel {
    FLEX, DIESEL;
    public static boolean have(String type) {
        for (Fuel f : Fuel.values()) {
            if (f.name().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
}
