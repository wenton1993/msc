package com.wt.myspringcloud.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {

    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        try {
            Class c1 = Class.forName(name);
            Class superC1 = c1.getSuperclass();
            // Modifier.toString 修饰符
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if (superC1 != null && superC1 != Object.class) {
                System.out.print(" extend " + superC1.getName());
            }
            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            /*printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Print all constructors of a class.
     *
     * @param c a class
     */
    public static void printConstructors(Class c) {
        // 获取所有构造器
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("    ");
            // Modifier.toString 修饰符
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
        }
    }

}
