package com.example.geek_for_less.thread_pool_executor;

import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    private static Queue<String> queue = new LinkedBlockingQueue<>();
    private static ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    static {
        for (int i = 0; i < 10; i++) {
            queue.add("Queue - " + i);
        }
    }

    public static void main(String[] args) {
        try {
            for (int x = 0; x < queue.size(); x++) {
                String string = queue.poll();
                Runnable runnable = () -> {
                    System.out.println(Thread.currentThread().getName() + " String - " + string);
                };
                threadPoolExecutor.execute(runnable);
            }
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}