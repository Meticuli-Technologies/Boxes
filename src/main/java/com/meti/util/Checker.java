package com.meti.util;

import java.util.function.Predicate;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/18/2019
 */
public interface Checker<T> {
    static <O> Predicate<O> wrap(Checker<O> clause) {
        return o -> {
            try {
                clause.check(o);
                return true;
            } catch (Exception e) {
                return false;
            }
        };
    }

    void check(T t) throws Exception;
}
