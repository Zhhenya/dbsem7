package com.db.campus.property.converter;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class CampusPropertyConverter<T, R> {

    public abstract R convert(T value);

    public List<R> convertAll(Iterable<T> objList) {
        List<R> convertedObjList = new ArrayList<>();
        objList.forEach(o -> convertedObjList.add(convert(o)));
        return convertedObjList;
    }

    public <K> String defaultConvert(K value, Function<K, String> converter) {
        if (value == null)
            return Strings.EMPTY;
        return converter.apply(value);
    }

    public <K, S> S defaultConvert(K value, Function<K, S> converter, S defaultValue) {
        if (value == null)
            return defaultValue;
        return converter.apply(value);
    }

}
