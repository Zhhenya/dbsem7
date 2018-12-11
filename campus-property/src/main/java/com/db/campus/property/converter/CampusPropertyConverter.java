package com.db.campus.property.converter;

import org.apache.logging.log4j.util.Strings;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

public abstract class CampusPropertyConverter<T, R> implements Converter<T, R> {

    public <K> String defaultConvert(K value, Function<K, String> converter) {
        if (value == null)
            return Strings.EMPTY;
        return converter.apply(value);
    }

}
