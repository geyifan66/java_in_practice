package com.ewan.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自定义类加载器
 * @author ewan
 */
public class CustomClassLoader extends ClassLoader {

    private String classpath;

    public CustomClassLoader(String classpath) {
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFilePath = getClassFilePath(name);
        byte[] classData = readClassFile(classFilePath);
        return defineClass(name, classData, 0, classData.length);
    }

    public String getClassFilePath(String name) {
        if (name.lastIndexOf(".") == -1) {
            return classpath + "/" + name + ".class";
        } else {
            name = name.replace(".", "/");
            return classpath + "/" + name + ".class";
        }
    }

    public byte[] readClassFile(String filepath) {
        Path path = Paths.get(filepath);
        if (!Files.exists(path)) {
            return null;
        }
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException("Can not read class file into byte array");
        }
    }

}
