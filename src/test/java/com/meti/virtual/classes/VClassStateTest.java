package com.meti.virtual.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VClassStateTest {

    @Test
    void print() {
        VClassState vClassState = new VClassState();
        assertEquals(vClassState.fieldRegistry.print() + "\n" + vClassState.methodRegistry.print(), vClassState.print());
    }
}