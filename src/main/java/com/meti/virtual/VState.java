package com.meti.virtual;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/13/2019
 */
public class VState {
    public final Map<String, VInvocation> invocations = new HashMap<>();

    public void add(VInvocation<?> invocation) {
        invocations.put(invocation.name, invocation);
    }
}
