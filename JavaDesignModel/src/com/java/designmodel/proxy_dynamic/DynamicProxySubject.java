package com.java.designmodel.proxy_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/27 23:59
 */
public class DynamicProxySubject implements InvocationHandler {


    private final Object mObject;

    public DynamicProxySubject(Object object) {
        mObject = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(mObject, args);
    }


}