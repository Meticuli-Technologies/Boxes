package com.meti.virtual;

import java.util.Objects;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VElement<T> {
    final T content;

    VElement(T content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VElement<?> vElement = (VElement<?>) o;
        return Objects.equals(content, vElement.content);
    }
}
