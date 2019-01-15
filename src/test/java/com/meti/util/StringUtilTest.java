package com.meti.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
class StringUtilTest {

    @Test
    void parentheses() {
        assertEquals("(test)", StringUtil.parentheses("test"));
    }

    @Test
    void encapsulate() {
        assertEquals("abc", StringUtil.encapsulate("a", "b", "c"));
    }
}