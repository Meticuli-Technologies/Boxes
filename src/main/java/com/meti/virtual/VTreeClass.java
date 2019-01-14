package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VTreeClass extends VClass {
    public VTreeClass(String name) {
        super(name);
    }

    public VTreeClass(VPackage vPackage, String name) {
        super(vPackage, name);
    }

    @Override
    public String printContent() {
        return null;
    }
}
