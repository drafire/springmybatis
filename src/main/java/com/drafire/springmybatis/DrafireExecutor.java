package com.drafire.springmybatis;

/**
 * 执行器
 */
public interface DrafireExecutor {
    <E> E query(String statement, Object parameter);
}
