package com.drafire.springmybatis;

import java.lang.reflect.Proxy;

public class DrafireSqlsession {
    private DrafireExecutor executor = new DrafireSimpleExecutor();

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new DrafireMapperProxy<T>(clazz, this));
    }

}
