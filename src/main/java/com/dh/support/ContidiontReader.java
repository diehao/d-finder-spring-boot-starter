package com.dh.support;

import com.dh.parsing.ParameterParseHandler;
import lombok.Data;

import javax.annotation.Nullable;
import java.util.function.Function;

@Data
public class ContidiontReader {

    private FinderDefinition definition;

    public <T> ContidiontReader(AbstractFinder<T> collectChange) {
        this.definition = ParameterParseHandler.parse(collectChange);
    }

    @Nullable
    public <T, R> R read(T object0,  @Nullable T object1, Function<String, R> callback) {
        return callback.apply(definition.query(object0, object1));
    }

    @Nullable
    public <T> String read(T object0,  @Nullable T object1) {
        return definition.query(object0, object1);
    }

}
