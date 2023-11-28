package io.github.diehao.support;

import io.github.diehao.parsing.ParseFunction;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFinder<T> {

    private List<ParseFunction<T, ?>> parameter;

    public AbstractFinder() {
        this.parameter = new ArrayList<>();

        final class CallbackImpl implements CollectCallback<T> {
            @Override
            public void add(ParseFunction<T, ?> factory) {
                parameter.add(factory);
            }
        }

        loadParameter(new CallbackImpl());
    }

    public abstract Class<T> getClazz();

    public List<ParseFunction<T, ?>> getParameter() {
        return parameter;
    }

    public abstract void loadParameter(CollectCallback<T> callback);

    public interface CollectCallback<T> {
        void add(ParseFunction<T, ?> factory);
    }
}
