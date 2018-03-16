package com.thenational.util;

import org.apache.commons.lang.math.NumberUtils;

public class NabUtils {

    private static int numberOfClassCalls = 0;
    private static int numberOfInstances = 0;

    static {
        numberOfClassCalls++;
    }

    public static int getNumberOfClassCalls() {
        return numberOfClassCalls;
    }

    public static int getNumberOfInstances() {
        return numberOfInstances;
    }

    public NabUtils() {
        numberOfInstances++;
    }

    public static boolean isNumber(String text) {
        return NumberUtils.isNumber(text);
    }

    public static String format(String text) {
        return "#" + text + "#";
    }
}
