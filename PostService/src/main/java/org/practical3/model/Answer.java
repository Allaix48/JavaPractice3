package org.practical3.model;

import java.util.Collection;

public class Answer {
    public Object Data;
    public String Status;
    public int Code;
    public Answer(Object data, String status,  int code) {
        Data = data;
        Status = status;
        Code = code;
    }
}
