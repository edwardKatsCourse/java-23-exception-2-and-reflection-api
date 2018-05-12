package com.company.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Person person = new Person();

        Class clazz = Class.forName("com.company.reflection.Person");
        //Class
        //Field
        //Method


        System.out.println(Arrays.toString(clazz.getFields()));
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));

        System.out.println("-------Get Declared fields --------");
        printFields(clazz.getDeclaredFields());

        System.out.println("-------Get fields --------");
        printFields(clazz.getFields());

        System.out.println("-------Get Methods---------");
        printMethods(clazz.getMethods());


        System.out.println("-------Get Declared Methods---------");
        printMethods(clazz.getDeclaredMethods());


        System.out.println("----- Simple Example -----");
        simpleToStringCall();

        System.out.println("----- Reflection Example -----");
        nonSimpleExample();
    }

    public static void nonSimpleExample() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;

        Object personObject = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equals("name")) {
                field.set(personObject, "Hello from Reflection API");
            }
        }
        System.out.println(personObject.toString());
    }

    public static void simpleToStringCall() throws IllegalAccessException, InstantiationException {
        //We should get Class object out of Person

        //1. Person.class

        //2.
        //Person person = new Person();
        //person.getClass();

        //3.
        //Class.forName("com.company.reflection.Person");

        Person person = Person.class.newInstance();
//        Person person = new Person();

        person.setAge(35);
        person.setName("Peter");
        person.isResident = true;
        person.spouse = new Person();


        System.out.println(person.toString());

    }

    public static void printFields(Field[] fields) {
        for (Field field : fields) {
            String modifierName = Modifier.toString(field.getModifiers());
            if (modifierName.isEmpty()) {
                modifierName = "[default]";
            }
            System.out.printf("Modifier: %s | Type: %s | Name: %s%n",
                    modifierName,
                    field.getType()
                            .getName()
                    /*.getTypeName()*/
                    /*.getSimpleName()*/,
                    field.getName());
        }

        System.out.println("------------------------");
    }

    public static void printMethods(Method[] methods) {
        for (Method method : methods) {
            String modifierName = Modifier.toString(method.getModifiers());
            if (modifierName.isEmpty()) {
                modifierName = "[default]";
            }
            System.out.printf("Modifier: %s | Type: %s | Name: %s()%n",
                    modifierName,
                    method.getReturnType()
                            .getName()
                    /*.getTypeName()*/
                    /*.getSimpleName()*/,
                    method.getName());
        }
        System.out.println("------------------------");

    }
}


