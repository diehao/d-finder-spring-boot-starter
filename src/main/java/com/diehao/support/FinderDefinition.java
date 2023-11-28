package com.diehao.support;

import com.diehao.parsing.ParseFunction;
import com.diehao.type.TypeHandle;
import com.diehao.type.TypeRegisterCenter;
import lombok.Getter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FinderDefinition {

    @Getter
    private Class clazz;
    @Getter
    private List<ParameterNode> mixed;

    public FinderDefinition(Class clazz) {
        this.clazz = clazz;
        this.mixed = new ArrayList<>();
    }

    public void addNode(ParseFunction parameterFactory, String name, Class<?> returnType) {
        TypeHandle typeHandle = TypeRegisterCenter.get(returnType);
        if (null == typeHandle) {
            throw new IllegalArgumentException("TypeRegisterCenter not find typeHandle");
        }
        this.mixed.add(new ParameterNode(parameterFactory, name, typeHandle));
    }

    public <T> String query(T object0, @Nullable T object1) {
        return this.mixed.stream().map(item -> item._hand(object0, object1)).filter(Objects::nonNull).collect(Collectors.joining(","));
    }

    protected class ParameterNode {
        @Getter
        private ParseFunction parameterFactory;
        @Getter
        private String name;
        @Getter
        private TypeHandle typeHandle;

        public ParameterNode(ParseFunction parameterFactory, String name, TypeHandle typeHandle) {
            this.parameterFactory = parameterFactory;
            this.name = name;
            this.typeHandle = typeHandle;
        }

        public <T> String _hand(T object0, @Nullable T object1) {
            Object var0 = this.parameterFactory.apply(object0);

            Object var1 = null != object1 ? this.parameterFactory.apply(object1) : null;

            if (!this.typeHandle.eq(var0, var1)) {
                return build(var1, var0, this.name);
            }
            return null;
        }
    }

    public String build(Object v0, Object v1, String name) {
        return name + ":" + format(v0) + "->" + format(v1);
    }

    public String format(Object v0) {
        return "[" + v0 + "]";
    }
}
