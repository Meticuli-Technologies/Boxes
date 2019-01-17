package com.meti.box;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class QueuedBoxBuilderTest {

    @Test
    void hasMoreElements() {
        QueuedBoxBuilder boxBuilder = new QueuedBoxBuilder();
        boxBuilder.elements.add(Mockito.mock(Box.class));
        assertTrue(boxBuilder.hasMoreElements());
    }

    @Test
    void nextElement() {
        Box mock = Mockito.mock(Box.class);

        QueuedBoxBuilder boxBuilder = new QueuedBoxBuilder();
        boxBuilder.elements.add(mock);
        assertEquals(mock, boxBuilder.nextElement());
    }
}