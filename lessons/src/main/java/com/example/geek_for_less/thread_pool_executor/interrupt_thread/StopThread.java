package com.example.geek_for_less.thread_pool_executor.interrupt_thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch mainCountDownLatch = new CountDownLatch(10);
        final CountDownLatch toAwaitSleepCountDownLatch = new CountDownLatch(1);

        Runnable runnable = () -> {
            System.out.println("Interrupted status on startup: " + Thread.currentThread().getName());
            int count = 0;


            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Thread name = " + Thread.currentThread().getName());
                    System.out.println("Work #" + count++);
                    toAwaitSleepCountDownLatch.countDown();
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted Exception!");
                    System.out.println("Interrupted status after exception = " + Thread.currentThread().isInterrupted());
                    // !!! ATTENTION !!!
                    // You must also interrupt current thread into method run
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupted status after exception and call method interrupt into run = " + Thread.currentThread().isInterrupted());
                }
            }
            mainCountDownLatch.countDown();
        };

        Thread thread = new Thread(runnable);
        thread.start();

        toAwaitSleepCountDownLatch.await();
        //It's done to simulate Interrupted exception
        thread.interrupt();
        mainCountDownLatch.await();
        System.out.println("Application completed!");
    }
}