package com.meti.virtual.classes;

import com.meti.virtual.packages.VPackage;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VStringClass extends VClass {
    final String content;

    public VStringClass(String name, String content) {
        super(name);
        this.content = content;
    }

    public VStringClass(VPackage vPackage, String name, String content) {
        super(vPackage, name);
        this.content = content;
    }

    @Override
    public String printContent() {
        return content;
    }
}
