package com.lsy.lib_base.data;

public class EvenBusMsg {
    //跳转到登录页面
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EvenBusMsg{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
