package com.drafire.springmybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DrafireMapperProxy<T> implements InvocationHandler {
    private final Class<T> mapperInterface;
    private final DrafireSqlsession sqlsession;

    public DrafireMapperProxy(Class<T> mapperInterface, DrafireSqlsession sqlsession) {
        this.mapperInterface = mapperInterface;
        this.sqlsession = sqlsession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(UserMapperXml.namespace)) {
            String sql = UserMapperXml.methodSqlMapping.get(method.getName());
            System.out.println(String.format("SQL [%s],parameter [%s]", sql, args[0]));
            return sqlsession.selectOne(sql, args[0]);
        }
        return null;
    }
}
