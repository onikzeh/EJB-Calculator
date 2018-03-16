package com.thenational.ejb.local;

import javax.ejb.Local;

@Local
public interface AddLocal {
    String add(String value1, String value2);
}
