package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class CallbackTest {

    @Test
    void throwIfPresentWithPresent() {
        Callback callback = new Callback(new Exception());
        assertThrows(Exception.class, callback::throwIfPresent);
    }

    @Test
    void throwIfPresentNoPresent() {
        Callback callback = new Callback();
        assertDoesNotThrow(callback::throwIfPresent);
    }

    @Test
    void setExceptionSet() {
        Callback callback = new Callback(new Exception());

        assertThrows(IllegalArgumentException.class, () -> callback.setException(new Exception()));
    }

    @Test
    void setExceptionNotSet() {
        Exception exception = new Exception();
        Callback callback = new Callback();
        callback.setException(exception);

        assertEquals(exception, callback.exception);
    }

    @Test
    void hasException() {
        Callback callback = new Callback(new Exception());
        assertTrue(callback.hasException());
    }
}