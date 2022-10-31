package com.example.geek_for_less.patterns.proxy;

import com.example.geek_for_less.patterns.proxy.proxy.ExpensiveObjectProxy;
import com.example.geek_for_less.patterns.proxy.service.ExpensiveObject;

public class App {

    public static void main(String[] args) {
        ExpensiveObject expensiveObject = new ExpensiveObjectProxy();
        // Initialization constructor with a big and heavy logic
        expensiveObject.process();

        //Call method without initialization constructor
        expensiveObject.process();
    }
}