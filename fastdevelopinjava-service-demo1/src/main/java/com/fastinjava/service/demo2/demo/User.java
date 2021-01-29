package com.fastinjava.service.demo2.demo;

import java.util.StringJoiner;
import java.util.function.Function;

public class User {


    private String username;
    private Integer age;

    public String sayHello(String who) {
        return "静谧的小树林里传来了 " + who + "的招呼";
    }

    public static String sayLove(String lover) {
        return "静谧的小树林里传来了 " + lover + "的欢乐声";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {

    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }


    public String test() {
        return "嘿嘿";
    }

    public String print(Function<User, String> function) {
        return function.apply(this);
    }

    public static void main(String[] args) {
        User user = new User("lifuyong", 12);
        String print = user.print(((Function<User, String>) user1 -> user1.username + "#" + user1.age).andThen(s -> "我的名片:" + s));
        System.out.println(print);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("age=" + age)
                .toString();
    }
}
