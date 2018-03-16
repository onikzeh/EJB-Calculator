package com.thenational.ejb.local;

import javax.ejb.Local;

@Local
public interface DevideLocal {
    String devide(String value1, String value2);
}
