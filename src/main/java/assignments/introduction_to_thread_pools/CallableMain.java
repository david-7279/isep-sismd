package main.java.assignments.introduction_to_thread_pools;

import main.java.assignments.introduction_to_thread_pools.thread.CallablePartialSum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableMain {
    private static final int N_PARTITIONS = 10;
    private static final int N_THREADS = 5;
    private static final int VEC_SIZE = 2000;

    public static void main(String[] args) {

        int[] data = new int[VEC_SIZE];

        for (int i = 0; i < VEC_SIZE; i++) {
            data[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

        int sizePart = VEC_SIZE / N_PARTITIONS;
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < N_PARTITIONS; i++) {
            int from = i * sizePart;
            int to = (i + 1) * sizePart;

            CallablePartialSum task = new CallablePartialSum(from, to, data);

            System.out.println("Creating task to sum from " + from +
                    " to " + to);

            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            try {
                totalSum += future.get();
            } catch (Exception e) {
                System.err.println("Error getting result: " + e.getMessage());
            }
        }

        System.out.println("Total sum: " + totalSum);

        System.out.println("All threads have finished.");
    }
}
