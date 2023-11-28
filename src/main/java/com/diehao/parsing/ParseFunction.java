package com.diehao.parsing;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.function.Function;

public interface ParseFunction<T, R> extends Function<T, R>, Serializable  {

    R apply(T t);

    default SerializedLambda getSerializedLambda() {
        try {
            Method method = getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            SerializedLambda serializedLambda = (SerializedLambda) method.invoke(this);
            method.setAccessible(true);
            return serializedLambda;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    default String getMethodName() {
        SerializedLambda serializedLambda = getSerializedLambda();
        String methodName = serializedLambda.getImplMethodName();
        return methodName;
    }
}