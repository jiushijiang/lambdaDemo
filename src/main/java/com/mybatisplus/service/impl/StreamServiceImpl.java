package com.mybatisplus.service.impl;

import com.mybatisplus.service.StreamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StreamServiceImpl implements StreamService {
    @Override
    public void updateList() {

        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //过滤姓张的

        list.stream().filter(s->s.startsWith("张")).
                filter(s->s.length()==3).
                forEach(System.out::println);

        //过滤名字为3的

        //

    }
}
