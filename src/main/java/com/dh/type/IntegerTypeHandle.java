package com.dh.type;

import javax.annotation.Nullable;

public class IntegerTypeHandle implements TypeHandle<Integer> {

    @Override
    public boolean eq(@Nullable Integer t1, @Nullable Integer t2) {
        if (t1 == null) {
            return null == t2;
        }
        return t1.equals(t2);
    }
}