package com.dh.type;

import java.util.HashMap;
import java.util.Map;

public class TypeRegisterCenter {
    private static final Map<Class, TypeHandle> register;

    static {
        register = new HashMap<>();
        register.put(String.class, new StringTypeHandle());
        register.put(Integer.class, new IntegerTypeHandle());
        register.put(int.class, new IntegerTypeHandle());
        register.put(Long.class, new LongTypeHandle());
        register.put(long.class, new LongTypeHandle());
    }

    public static TypeHandle get(Class clazz) {
        return register.get(clazz);
    }

}
