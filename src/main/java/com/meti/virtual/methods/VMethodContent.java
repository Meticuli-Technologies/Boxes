package com.meti.virtual.methods;

import com.meti.virtual.imports.VImport;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
public interface VMethodContent {
    String getContent(VImport returnType, VParameter[] parameters);
}
