package com.diehao.type;

import javax.annotation.Nullable;

public interface TypeHandle<T> {

    boolean eq(@Nullable T t1, @Nullable T t2);
}