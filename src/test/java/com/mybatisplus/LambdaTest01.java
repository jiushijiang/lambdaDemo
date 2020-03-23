package com.mybatisplus;

import com.mybatisplus.service.LambdaService;
import com.mybatisplus.service.impl.LambdaServiceImpl;
import org.apache.tomcat.jni.Thread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LambdaTest01 {

    @Autowired
    private LambdaService lambdaService;
    /**
     * 用来测试lambda延迟加载
     */
    @Test
    public void test01(){

        lambdaService.getMessage();

    }

    @Test
    public void test02(){
        lambdaService.startThread();


    }

    @Test
    public void test03(){


        lambdaService.sort();
    }

    /**
     * {}相当于lambda接口的实现方法
     */
    @Test
    public void test04(){

        Integer serviceMax = lambdaService.getMax();
        System.out.println(serviceMax);

    }
    @Test
    public void test05(){

        lambdaService.sayMessage();
    }

    @Test
    public void test06(){
        lambdaService.andThen();

    }

    @Test
    public void test07(){

        lambdaService.spiltMessage();


    }
    @Test
    public void test08(){

        lambdaService.checkStr();
    }

    @Test
    public void test09(){

        lambdaService.checkStr01();
    }

    @Test
    public void test10(){

        lambdaService.checkStr02();
    }
    @Test
    public void test11(){

        lambdaService.confirm();
    }


    @Test
    public void test12(){

        lambdaService.getResult();
    }




}
