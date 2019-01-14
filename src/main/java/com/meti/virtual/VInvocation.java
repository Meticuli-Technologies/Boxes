package com.meti.virtual;

import com.meti.Clause;

import static com.meti.util.StringUtil.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/13/2019
 */
public class VInvocation<P> implements Virtual {
    public final String name;
    private final Clause<P> handler;

    public VInvocation(String name, Clause<P> handler) {
        this.name = name;
        this.handler = handler;
    }

    @Override
    public String toContent() {
        return end("state.invoke" + parentheses(name));
    }
}