package com.fc.entity;

import java.util.List;

public class TbNoteType {
    private Integer id;

    private String typeName;

    private Integer userId;
    List<TbUser> users;


    public List<TbUser> getUsers() {
        return users;
    }

    public void setUsers(List<TbUser> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}