package com.test.just.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        // 클래스 이름으로부터 클래스 객체를 가져옵니다.
//        Class<?> classObj = MyClass.class;
        Class<?> classObj = Class.forName("com.test.just.java.reflection.MyClass");

        // 클래스의 모든 필드를 가져옵니다.
        Field[] fields = classObj.getDeclaredFields();
        System.out.println("Fields of MyClass:");
        for (Field field : fields) {
            System.out.println("- " + field.getName());
        }

        MyClass myClass = new MyClass();
        // 클래스의 모든 메소드를 가져옵니다.
        Method[] methods = classObj.getDeclaredMethods();
        System.out.println("\nMethods of MyClass:");
        for (Method method : methods) {
            System.out.println("- " + method.getName());
            method.setAccessible(true);
            method.invoke(myClass);
        }


    }
}

class MyClass {
    private int field1;
    public String field2;

    public void method1() {
        System.out.println("method1");
    }
    private void method2() {
        System.out.println("method2");
    }
}
