package com.mybatisplus.service.impl;

import com.mybatisplus.interfaceEnttity.MessageBuilder;
import com.mybatisplus.service.LambdaService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service
public class LambdaServiceImpl implements LambdaService {
    @Override
    public void getMessage() {
        String msgA = "Hello";
        String msgB = " World";
        String msgC = " Java";

        log(2, () -> {
            System.out.println("Lambda执行！");//判断是否执行
            return msgA + msgB + msgC;
        });


    }

    @Override
    public void startThread() {

        startRunnable(() -> {
            System.out.println("线程执行中......");
        });


    }

    @Override
    public void sort() {
        String[] array = {"abc", "ab", "abcd"};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, newComparator());
        System.out.println(Arrays.toString(array));
    }

    @Override
    public Integer getMax() {

        int arr[] = {2, 3, 4, 52, 333, 23};

        int max1 = getMax(() -> {
            Integer max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }

            }

            return max;


        });


        return max1;
    }

    @Override
    public void sayMessage() {

        customer(s ->
                System.out.println(s)
        );


    }


    @Override
    public void andThen() {

        customer(
                s -> {
                    System.out.println(s.toLowerCase());
                },
                s -> {
                    System.out.println(s.toUpperCase());
                }
        );

    }

    @Override
    public void spiltMessage() {

        String[] msg = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};

        splitMsg(s->{
            String[] str=s.split(",");

            System.out.print("姓名:"+str[0]+"\t");
        },s->{
            String[] str=s.split(",");

            System.out.println("性别:"+str[1]);
        },msg);


    }


    @Override
    public void checkStr() {

        boolean length = isLength(s ->
                s.length() > 5
        );
        System.out.println(length);


    }

    /**
     * 判断一个字符是否包括w和a
     */
    @Override
    public void checkStr01() {

        String str="hello world";

        boolean current = isCurrent(
                s -> s.contains("w"),
                s -> s.contains("a"),
                str


        );

        System.out.println(current);

    }

    /**
     * 过滤：
     *  1.过滤性别为女
     */
    @Override
    public void checkStr02() {

        String[] msg = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        List<String> list=new ArrayList<>();

        for (String s : msg) {

            String display = display(s1 -> {
                String[] str = s1.split(",");
                if (str[1].contains("女")) {
                    return true;
                }
                return false;
            }, s2 -> {
                String[] str = s2.split(",");
                if (str[0].length() >= 4) {
                    return true;
                }
                return false;
            }, s);
            if (display != null) {
                list.add(display);
            }


        }

        System.out.println(list);



    }

    private static Comparator<String> newComparator() {
        return (a, b) -> b.length() - a.length();
    }

    private static void log(Integer num, MessageBuilder msg) {

        if (num == 1) {
            System.out.println(msg);
        }
    }

    private static void startRunnable(Runnable task) {

        new Thread(task).start();
        System.out.println("线程已经执行了");
    }

    private int getMax(Supplier<Integer> supplier) {
        return supplier.get();

    }

    private static void customer(Consumer<String> consumer) {

        consumer.accept("hello");
    }

    private static void customer(Consumer<String> cu1, Consumer<String> cu2) {

        cu1.andThen(cu2).accept("Hello");
    }

    private static void splitMsg(Consumer<String> cu1, Consumer<String> cu2,String[] msg) {



        for (String s : msg) {
            cu1.andThen(cu2).accept(s);
        }


    }

    private static boolean isLength(Predicate<String> predicate){

        boolean flag=predicate.test("helloworld");
        return flag;
    }

    private static boolean isCurrent(Predicate<String> pre1,Predicate<String> pre2,String str){

        return pre1.and(pre2).negate().test(str);


    }

    private static String display(Predicate<String> pre1,Predicate<String> pre2,String str2){

        boolean b = pre1.and(pre2).test(str2);
        if (b){

            return str2;
        }
        return null;


    }

}
