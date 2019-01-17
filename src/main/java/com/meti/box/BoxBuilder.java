package com.meti.box;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/17/2019
 */
public interface BoxBuilder<S> {
    Box build(S source) throws Exception;
}
