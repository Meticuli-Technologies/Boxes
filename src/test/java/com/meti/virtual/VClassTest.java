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
    void print() {
        VClass vClass = new VClass(new VPackage("com", "meti"), "Main", "content");
        assertEquals("package com.meti;\ncontent", vClass.print());
    }

    @Test
    void getSimpleName(){
        VClass vClass = new VClass(new VPackage("com", "meti"), "Main", "content");
        assertEquals("com.meti.Main", vClass.getSimpleName());
    }

    @Test
    void constructWithContent() {
        VClass vClass = new VClass("Main", "content");
        assertEquals("Main", vClass.name);
        assertEquals("content", vClass.content);
    }

    @Test
    void constructWithContentAndPackage(){
        VClass vClass = new VClass(new VPackage("com", "meti"), "Main", "content");
        assertEquals(new VPackage("com", "meti"), vClass.vPackage);
        assertEquals("Main", vClass.name);
        assertEquals("content", vClass.content);
    }
}
