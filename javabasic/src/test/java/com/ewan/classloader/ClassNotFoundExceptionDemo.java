package com.ewan.classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 测试ClassNotFoundException异常
 * @author ewan
 */
public class ClassNotFoundExceptionDemo {

    public static void main(String[] args) throws MalformedURLException {
        CustomClassLoader loader = new CustomClassLoader("/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/rt.jar");
        File file  = new File("/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/rt.jar");

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});

        try {

            System.out.println("父类加载器："+ClassNotFoundExceptionDemo.class.getClassLoader().getParent());
            // 尝试装载不在ExtClassLoader负责范围内的类时，由于可见性的约束，抛出ClassNotFoundException
            Class.forName("com.ewan.classloader.ClassNotFoundExceptionDemo",
                    true,ClassNotFoundExceptionDemo.class.getClassLoader().getParent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
