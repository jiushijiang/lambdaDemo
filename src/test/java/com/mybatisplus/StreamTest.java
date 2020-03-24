package com.mybatisplus;

import com.mybatisplus.service.StreamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StreamTest {

    @Autowired
    private StreamService streamService;


    @Test
    public void test01(){

        streamService.updateList();


    }
}
