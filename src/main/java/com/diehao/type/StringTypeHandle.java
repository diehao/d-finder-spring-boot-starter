package com.diehao.type;

import com.diehao.util.LocalKit;

import javax.annotation.Nullable;

public class StringTypeHandle implements TypeHandle<String> {

    @Override
    public boolean eq(@Nullable String t1, @Nullable String t2) {
        return LocalKit.equals(t1, t2);
    }
}