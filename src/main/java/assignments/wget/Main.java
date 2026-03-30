package main.java.assignments.wget;


import main.java.assignments.wget.service.WebTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int N_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {

        // 1. Criar o ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

        // 2. Submeter a primeira WebTask
        WebTask webTask = new WebTask("https://www.google.com", 0, 2, executor);
        executor.submit(webTask);

        // 3. Shutdown do pool
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("All tasks completed.");
    }
}
