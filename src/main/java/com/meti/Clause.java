package com.meti;

import java.util.function.Consumer;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/13/2019
 */
public abstract class Clause<P> implements Consumer<P[]> {
    public final Callback callback = new Callback();

    @Override
    public void accept(P[] parameters) {
        try {
            acceptThrows(parameters);
        } catch (Exception e) {
            callback.setException(e);
        }
    }

    protected abstract void acceptThrows(P[] parameters) throws Exception;
}
