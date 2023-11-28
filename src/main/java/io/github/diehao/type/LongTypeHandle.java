package io.github.diehao.type;

import javax.annotation.Nullable;

public class LongTypeHandle implements TypeHandle<Long> {
    @Override
    public boolean eq(@Nullable Long t1, @Nullable Long t2) {
        if (t1 == null) {
            return null == t2;
        }
        return t1.equals(t2);
    }
}
