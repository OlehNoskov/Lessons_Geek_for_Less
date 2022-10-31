package com.example.geek_for_less.patterns.proxy.service;

public class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    @Override
    public void process() {
        System.out.println("Processing complete!");
    }

    private void heavyInitialConfiguration() {
        System.out.println("Loading initial configuration!");
    }
}