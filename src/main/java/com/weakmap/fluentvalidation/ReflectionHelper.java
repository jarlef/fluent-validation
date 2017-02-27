package com.weakmap.fluentvalidation;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import org.objenesis.ObjenesisHelper;

class ReflectionHelper {

    @SuppressWarnings("all")
    static <T> Recorder<T> createProxy(final Class<T> classToMock) {
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(classToMock);

        RecordingObject interceptor = new RecordingObject();
        enhancer.setCallbackType(interceptor.getClass());

        final Class<?> proxyClass = enhancer.createClass();
        Enhancer.registerCallbacks(proxyClass, new Callback[] { interceptor });
        return new Recorder<T>((T) ObjenesisHelper.newInstance(proxyClass), interceptor);
    }

}