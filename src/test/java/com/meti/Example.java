package com.meti;

import com.meti.box.Box;
import com.meti.virtual.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/12/2019
 */
public class Example {
    public static void main(String[] args) {
        VState state = new VState();
        state.add(new VInvocation<String>("print", new Clause<>() {
            @Override
            public void acceptThrows(String[] parameters) {
                System.out.println(String.join(" ", parameters));
            }
        }));

        VClass vClass = new VClass("Main");
        vClass.vPackage = new VPackage("com", "meti");
        vClass.modifiers.add(VModifier.PUBLIC);

        VMethod method = new VMethod("main");
        method.modifiers.addAll(Arrays.asList(VModifier.PUBLIC, VModifier.STATIC));
        method.body = state.invocations.get("print").toContent();

        vClass.methods.add(method);

        Path directory = Paths.get(".\\modules");
        VJAR vjar = new VJAR(vClass);
        VJARBuilder builder = new VJARBuilder(vjar);
        builder.directory = directory;
        builder.write();
        builder.compile();
        builder.assemble();

        ClassLoader jarLoader = builder.toClassLoader();
        Box box = new Box(jarLoader);

        var service = Executors.newCachedThreadPool();
        service.submit(box.createStart());
        service.submit(box.createStop());
    }
}
