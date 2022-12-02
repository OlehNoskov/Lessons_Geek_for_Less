package com.example.geek_for_less.thread_pool_executor;

import java.util.Queue;
import java.util.concurrent.*;

public class Main {

    // ConcurrentLinkedDeque is safe in multithreading
    private static final Queue<String> SCENARIO = new ConcurrentLinkedDeque<>();
    private static final Queue<String> PROXY = new ConcurrentLinkedDeque<>();
    // Counter working threads
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(4);

    private static ExecutorService executorService = Executors.newFixedThreadPool(6);

    public static void main(String[] args) throws InterruptedException {
        Runnable scenarioRun = () -> {
            for (int i = 0; i < 10; i++) {
                SCENARIO.add("Scenario - " + i);
            }
            System.out.println(String.format("Finish SCENARIO Thread - %s,",
                    Thread.currentThread().getName()));

            // Cut down counter threads, we show, that this thread finished
//            COUNT_DOWN_LATCH.countDown();
        };

        Runnable proxiesRun = () -> {
            for (int i = 0; i < 10; i++) {
                PROXY.add("PROXY - " + i);
            }
            System.out.println(String.format("Finish PROXY Thread - %s,",
                    Thread.currentThread().getName()));

//            COUNT_DOWN_LATCH.countDown();
        };

        executorService.execute(scenarioRun);
        executorService.execute(proxiesRun);

//        new Thread(scenarioRun).start();
//        new Thread(proxiesRun).start();

        int countWorkers = 4;

        for (int a = 0; a < countWorkers; a++) {
            Runnable worker = () -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    // Poll = return element from queue and delete it.
                    String currentScenario = SCENARIO.poll();
                    String currentProxy = PROXY.poll();

                    System.out.println(String.format("Worker - %s ,Scenario - %s, Proxy - %s",
                            Thread.currentThread().getName(), currentScenario, currentProxy));
                }
                COUNT_DOWN_LATCH.countDown();

                System.out.println(String.format("Finish Worker Thread - %s",
                        Thread.currentThread().getName()));
            };

            executorService.execute(worker);
//            new Thread(worker).start();
        }

//         CountDownLatch.await() - Thread main waiting for the end work another threads
        COUNT_DOWN_LATCH.await();
        //close threads
        executorService.shutdown();
        System.out.println(String.format("Finish Main Thread - %s",
                Thread.currentThread().getName()));
    }
}