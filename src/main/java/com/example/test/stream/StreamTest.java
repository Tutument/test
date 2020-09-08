package com.example.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("1", "2", "3");
        List<String> collect = list.stream().filter(e->e.equalsIgnoreCase("1")).collect(Collectors.toList());

    }


}
