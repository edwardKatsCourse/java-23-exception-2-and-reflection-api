package com.company.reflection;

public class Person {
    private String name;

    Integer age;

    public Boolean isResident;
    protected Person spouse;

    public Person() {
//        init();
    }

    private void init() {
        System.out.println("init");
        if (this.age == null) {
            this.age = 50;
        }

        if (this.name == null) {
            this.name = "default name";
        }
    }

    public String getName() {
        System.out.println("getName()");
        return name;
    }

    public Integer getAge() {
        System.out.println("getAge()");
        return age;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public void setAge(Integer age) {
        System.out.println("setAge");
        this.age = age;
    }
    //        this.age = age;
    //        this.name = name;
    //    public Person(String name, Integer age) {

//    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isResident=" + isResident +
                ", spouse=" + spouse +
                '}';
    }
}