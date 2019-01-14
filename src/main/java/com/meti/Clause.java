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
    public void accept(P[] p) {
        try {
            acceptThrows(p);
        } catch (Exception e) {
            callback.setException(e);
        }
    }

    public abstract void acceptThrows(P[] p) throws Exception;
}
