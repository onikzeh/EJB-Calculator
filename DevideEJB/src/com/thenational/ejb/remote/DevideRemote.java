package com.thenational.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface DevideRemote {
    String devide(String value1, String value2);
}
