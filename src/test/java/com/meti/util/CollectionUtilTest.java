package com.meti.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
class CollectionUtilTest {

    @Test
    void toSingleOnePresent() {
        String result = CollectionUtil.toSingle(Collections.singletonList("test"));
        assertEquals("test", result);
    }

    @Test
    void toSingleZeroPresent(){
        assertThrows(IllegalArgumentException.class, () -> CollectionUtil.toSingle(Collections.emptySet()));
    }

    @Test
    void toSingleMultiplePresent(){
        assertThrows(IllegalArgumentException.class, () -> CollectionUtil.toSingle(Arrays.asList("test0", "test1")));
    }
}