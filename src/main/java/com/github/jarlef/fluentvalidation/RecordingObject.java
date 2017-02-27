package com.github.jarlef.fluentvalidation;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@SuppressWarnings("all")
class RecordingObject implements MethodInterceptor {

    private String currentPropertyName = "";
    private Recorder<?> currentMock = null;

    public RecordingObject() {
    }

    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        currentPropertyName = method.getName();
        return methodProxy.invokeSuper(object, args);
    }

    String getCurrentPropertyName() {
        return currentPropertyName + (currentMock == null ? "" : ("." + currentMock.getCurrentPropertyName()));
    }
}