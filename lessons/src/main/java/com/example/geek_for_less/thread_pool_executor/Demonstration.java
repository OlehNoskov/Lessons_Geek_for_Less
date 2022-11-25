package com.example.geek_for_less.thread_pool_executor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demonstration {
    public static void main( String args[] ) throws InterruptedException {

        // create an instance of the ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 1,
                TimeUnit.MINUTES, new LinkedBlockingDeque<>(3), new ThreadPoolExecutor.AbortPolicy());

        try {
            // submit six tasks
            for (int i = 0; i < 6; i++) {
                threadPoolExecutor.submit(() -> {
                    System.out.println("This is worker thread " + Thread.currentThread().getName() + " executing");
                    try {
                        // simulate work by sleeping for 1 second
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        // ignore for now
                    }
                });
            }

        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}