package kyu6;


import java.util.ArrayList;
import java.util.List;


public class Dinglemouse {
    private String name;
    private int age;
    private char sex;
    private final List<String> order = new ArrayList<>();

    public Dinglemouse() {
    }

    public Dinglemouse setAge(int age) {
        this.age = age;
        remember("age");
        return this;
    }

    public Dinglemouse setSex(char sex) {
        this.sex = sex;
        remember("sex");
        return this;
    }

    public Dinglemouse setName(String name) {
        this.name = name;
        remember("name");
        return this;
    }

    public String hello() {
        StringBuilder stringBuilder = new StringBuilder().append("Hello. ");
        order.forEach(o -> {
            if (o.equals("name")) {
                stringBuilder.append("My name is ").append(name).append(". ");
            }
            if (o.equals("sex")) {
                stringBuilder.append("I am ").append(sex == 'M' ? "male" : "female").append(". ");
            }
            if (o.equals("age")) {
                stringBuilder.append("I am ").append(age).append(". ");
            }
        });
        return stringBuilder.toString().strip();
    }

    private void remember(String property) {
        if (!order.contains(property)) {
            order.add(property);
        }
    }
}
