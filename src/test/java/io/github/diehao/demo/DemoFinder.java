package io.github.diehao.demo;

import io.github.diehao.support.AbstractFinder;

public class DemoFinder extends AbstractFinder<Demos> {

    @Override
    public Class<Demos> getClazz() {
        return Demos.class;
    }

    @Override
    public void loadParameter(CollectCallback<Demos> callback) {
        callback.add(Demos::getName);
        callback.add(Demos::getLocal);
        callback.add(Demos::getAge);
    }
}
