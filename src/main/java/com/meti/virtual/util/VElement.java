package com.meti.virtual.util;

import java.util.Objects;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VElement<T> {
    public final T content;

    public VElement(T content) {
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
