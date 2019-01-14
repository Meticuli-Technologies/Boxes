package com.meti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VClassTest {
    @Test
    void constructWithContent() {
        VClass vClass = new VClass("content");
        Assertions.assertEquals("content", vClass.content);
    }

 /*   @Test
    void constructWithContentAndPackage(){
        VClass vClass = new VClass(new VPackage("com", "meti"), content");
    }*/
}
