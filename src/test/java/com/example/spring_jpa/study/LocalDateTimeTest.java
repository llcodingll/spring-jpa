package com.example.spring_jpa.study;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

class LocalDateTimeTest {
    @Test
    void test1(){
//        js new Date()
//        현재 연월일 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
//        현재 연월일 시간
        Date date = new Date();
        System.out.println(date);
    }
}
