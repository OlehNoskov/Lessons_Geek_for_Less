package com.example.geek_for_less.testing_void_methods;

public class TesterImpl implements Tester {

    //Service method
    @Override
    public void setupTest(String param) {
        setupTest(param, null);
    }

    //Method for testing
    @Override
    public void setupTest(String param, Runnable callback) {
        System.out.println("Param setup step 1 " + param);
        if (param.equals("test param")) {
            if (callback != null) {
                callback.run();
                System.out.println("Param setup step 2 " + param);
            }
        }
    }
}
