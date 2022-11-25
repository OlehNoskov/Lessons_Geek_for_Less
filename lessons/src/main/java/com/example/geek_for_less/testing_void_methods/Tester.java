package com.example.geek_for_less.testing_void_methods;

public interface Tester {
    void setupTest(String param);
    void setupTest(String param, Runnable runnable);
}