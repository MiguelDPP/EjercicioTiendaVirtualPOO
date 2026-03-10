package com.miguecode.tiendavirtualpoo.util;

public class Validator {
    // Validaciones basicas
    public static boolean isNotEmpty(String value) {
        return !value.trim().isEmpty();
    }

    public static boolean positiveNumber(Number number) {
        return number.intValue() > 0;
    }
}
