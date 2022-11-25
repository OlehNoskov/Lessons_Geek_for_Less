package com.example.geek_for_less.thread_pool_executor;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        System.out.println(list);
    }
}
