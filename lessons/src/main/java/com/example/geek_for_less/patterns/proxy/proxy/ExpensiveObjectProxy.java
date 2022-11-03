package com.example.geek_for_less.patterns.proxy.proxy;

import com.example.geek_for_less.patterns.proxy.service.ExpensiveObject;
import com.example.geek_for_less.patterns.proxy.service.ExpensiveObjectImpl;

// One of other way apply Proxy pattern
public class ExpensiveObjectProxy implements ExpensiveObject {

    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}