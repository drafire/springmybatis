package com.drafire.springmybatis;

import java.util.HashMap;
import java.util.Map;

public class UserMapperXml {
    public static final String namespace = "com.drafire.springmybatis.UserDAO";
    public static final Map<String, String> methodSqlMapping = new HashMap<>();

    static {
        methodSqlMapping.put("getUser", "select * from t_user where id = ?");
    }
}
