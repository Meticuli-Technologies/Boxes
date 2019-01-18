package com.meti.util;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/18/2019
 */
public interface Clause<T, R> {
    static <I, O> Function<I, Optional<O>> wrap(Clause<I, O> clause) {
        return i -> {
            try {
                return Optional.of(clause.applyThrows(i));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    R applyThrows(T t) throws Exception;

}
