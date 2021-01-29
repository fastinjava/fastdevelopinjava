package com.fastinjava.service.demo2.demo;

import com.google.common.base.Function;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo3 {
    public static void main(String[] args) {

        /**
         * 方法引用之构造方法(返回一个对象)
         *  1\默认无参构造方法：没有接收参数，返回对象实例，这明显是一个Supplier
         *  2\有参构造方法：1 input Function；2 input BiFunction
         */
        /**
         * 1\默认无参构造方法：没有接收参数，返回对象实例，这明显是一个Supplier
         */
        Supplier<User> userSupplier = User::new;
        User user = userSupplier.get();
        /**
         * 1 input,0 return Consumer
         */
        Consumer<String> userSetUsernameConsumer = user::setUsername;
        userSetUsernameConsumer.accept("lienze");
        /**
         * 0 input 1 return Supplier
         */
        Supplier<String> userGetUsername = user::getUsername;
        System.out.println(userGetUsername.get());
        System.out.println(user.toString());

        /**
         * 2\有参构造方法：1 input Function；2 input BiFunction
         */
        BiFunction<String, Integer, User> userFunction = User::new;
        System.out.println(userFunction.apply("lichangjun", 99));


        /**
         * 静态方法的方法引用 (类名形式)
         */
        Function<String, String> sayLove = User::sayLove;
        System.out.println(sayLove.apply("古力娜扎"));

        /**
         * 非静态方法的方法引用 (类名形式)
         * Java中非静态方法的第一个参数因为当前类类名(Class clazz,param1,param2 ...)
         */
        BiFunction<User, String, String> sayHello = User::sayHello;
        System.out.println(sayHello.apply(new User(), "迪丽热巴"));
        /**
         * 非静态方法的方法引用 (实例形式)
         */

        Function<String, String> sayHello1 = user::sayHello;
        System.out.println(sayHello1.apply("马儿扎哈"));


    }
}
