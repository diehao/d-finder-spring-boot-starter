package com.dh.parsing;

import com.dh.support.AbstractFinder;
import com.dh.support.FinderDefinition;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParameterParseHandler {

    public static final Map<Class, FinderDefinition> cache = new ConcurrentHashMap<>();

    public static FinderDefinition parse(AbstractFinder collectChange) {
        return cache.computeIfAbsent(collectChange.getClazz(), (key) -> doparse(collectChange));
    }

    public static FinderDefinition doparse(AbstractFinder collectChange) {
        FinderDefinition definition = new FinderDefinition(collectChange.getClazz());

        Map<String, Method> methodMap = Stream.of(collectChange.getClazz().getMethods())
                .filter(item -> item.getName().startsWith("get"))
                .collect(Collectors.toMap(item -> item.getName(), Function.identity(), (k1, k2) -> k2));

        for (ParseFunction item : ((List<ParseFunction>) collectChange.getParameter())) {
            String methodName = item.getMethodName();
            Method method = methodMap.get(methodName);
            if (null != method) {
                definition.addNode(item, methodName.substring(3), method.getReturnType());
            }
        }
        return definition;
    }

}
