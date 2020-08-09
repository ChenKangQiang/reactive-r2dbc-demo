package com.example.reactiver2dbademo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2020/8/3
 */
@Data
@AllArgsConstructor
@ToString
public class Person {
    private String id;
    private String name;
    private int age;
}
