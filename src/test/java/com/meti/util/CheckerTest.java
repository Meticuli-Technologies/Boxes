package com.meti.util;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/18/2019
 */
class CheckerTest {

    @Test
    void wrapTrue() {
        Predicate<Object> wrap = Checker.wrap(o -> {
        });
        assertTrue(wrap.test(""));
    }

    @Test
    void wrapFalse() {
        Predicate<Object> wrap = Checker.wrap(o -> {
            throw new Exception();
        });
        assertFalse(wrap.test(""));
    }
}