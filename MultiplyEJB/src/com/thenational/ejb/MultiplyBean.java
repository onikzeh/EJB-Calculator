package com.thenational.ejb;

import com.thenational.ejb.local.MultiplyLocal;
import com.thenational.util.NabUtils;

public class MultiplyBean implements MultiplyLocal {

    public MultiplyBean() {
    }

    public String multiply(String value1, String value2) {
        if (NabUtils.isNumber(value1) && NabUtils.isNumber(value2)) {
            return "" + Integer.parseInt(value1) * Integer.parseInt(value2);
        } else {
            return value1 + " * " + value2;
        }

    }
}
