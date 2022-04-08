package com.fc.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ComplexType {
    private List<UserInfo> list;
    private Map <String,Object> map;

}
