package com.github.michael_sharko.models;

import java.util.ArrayList;
import java.util.List;

public class Answer<Table>
{
    private final String status;
    private String message;
    private List<Table> list;

    public Answer(String status, List<Table> list)
    {
        this.status = status;
        this.list = list;
    }

    public Answer(String status, Table user)
    {
        this.status = status;
        this.list = new ArrayList<>();

        list.add(user);
    }

    public Answer(String status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public List<Table> getList()
    {
        return list;
    }

    public String getStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }
}
