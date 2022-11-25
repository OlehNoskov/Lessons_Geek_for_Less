package com.example.geek_for_less.thread_pool_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SimpleThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
           Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
           threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}