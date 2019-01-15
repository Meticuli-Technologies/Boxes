package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
public class VGenericRegistry<T> extends VRegistry<T, VElement<T>> {
    @SafeVarargs
    public VGenericRegistry(T... content) {
        super(VElement::new, content);
    }
}