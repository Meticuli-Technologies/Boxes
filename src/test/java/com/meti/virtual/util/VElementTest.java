package com.meti.virtual.util;

import com.meti.virtual.util.VElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
class VElementTest {

    @Test
    void equals() {
        VElement<String> element0 = new VElement<>("test");
        VElement<String> element1 = new VElement<>("test");

        assertEquals(element0, element1);
    }
}