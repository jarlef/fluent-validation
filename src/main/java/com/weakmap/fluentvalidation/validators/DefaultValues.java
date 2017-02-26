package com.weakmap.fluentvalidation.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class DefaultValues {
    private static final Map<Class<?>,Object> defaultValues = new HashMap<>();

    // load
    static {
        defaultValues.put(boolean.class, Boolean.FALSE);
        defaultValues.put(Boolean.class, Boolean.FALSE);
        defaultValues.put(byte.class, (byte) 0);
        defaultValues.put(Byte.class, (byte) 0);
        defaultValues.put(short.class, (short) 0);
        defaultValues.put(Short.class, (short) 0);
        defaultValues.put(int.class, 0);
        defaultValues.put(Integer.class, 0);
        defaultValues.put(long.class, 0L);
        defaultValues.put(Long.class, 0L);
        defaultValues.put(char.class, '\0');
        defaultValues.put(Character.class, '\0');
        defaultValues.put(float.class, 0.0F);
        defaultValues.put(Float.class, 0.0F);
        defaultValues.put(double.class, 0.0);
        defaultValues.put(Double.class, 0.0F);
    }

    static <T> T defaultValueFor(Class clazz) {
        return (T)defaultValues.get(clazz);
    }

}