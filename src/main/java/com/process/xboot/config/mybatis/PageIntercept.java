package com.process.xboot.config.mybatis;

import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),})
public class PageIntercept implements Interceptor {

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Object parameter = args[1];
        Page page = null;

        if (parameter instanceof Page) {
            page = (Page) parameter;
        } else if (parameter instanceof Map) {
            for (Entry<String, Object> entry : ((Map<String, Object>) parameter).entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Page) {
                    page = (Page) value;
                    break;
                }
            }
        }

        PageRowBounds pageRowBounds = null;
        if (page != null) {
            pageRowBounds =
                    new PageRowBounds(page.getPageSize() * (page.getPageNum() - 1), page.getPageSize());
            pageRowBounds.setCount(Boolean.valueOf(true));
            args[2] = pageRowBounds;
        }
        Object value = invocation.proceed();

        if (page != null) {
            page.setEntities((Collection) value);
            page.setTotal(pageRowBounds.getTotal().intValue());
        }

        return value;
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
