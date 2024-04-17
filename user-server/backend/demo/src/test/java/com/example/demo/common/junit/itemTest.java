package com.example.demo.common.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class itemTest {

    @Test
    void print() {
        item s = new item();
        String s3 = s.print();
        System.out.println("-->"+s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.print(), "Hello");
    }

    @Test
    void add() {
        item s= new item();
        Assertions.assertEquals(s.add(4,3),7);

    }
}