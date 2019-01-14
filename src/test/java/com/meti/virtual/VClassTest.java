package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VClassTest {
    @Test
    void constructWithContent() {
        VClass vClass = new VClass("content");
        assertEquals("content", vClass.content);
    }

    @Test
    void constructWithContentAndPackage(){
        VClass vClass = new VClass(new VPackage("com", "meti"), "content");
        assertEquals(new VPackage("com", "meti"), vClass.vPackage);
        assertEquals("content", vClass.content);
    }
}
