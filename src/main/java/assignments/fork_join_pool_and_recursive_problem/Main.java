package main.java.assignments.fork_join_pool_and_recursive_problem;

import main.java.assignments.fork_join_pool_and_recursive_problem.service.Fibonacci;
import main.java.assignments.fork_join_pool_and_recursive_problem.service.SumTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void testAverage() {
        List<Long> list = new ArrayList<>();
        ForkJoinPool pool = new ForkJoinPool();
        Random rand = new Random();

        for (int i = 0; i < 10_000_000; i++) {
            list.add((long) rand.nextInt(500));
        }

        long start = System.nanoTime();
        SumTask task = new SumTask(list, 0, list.size());
        pool.execute(task);
        Long sum = task.join();
        double avg = (double) sum / 10_000_000;
        System.out.println("Average (ForkJoin): " + avg);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " ns");

        start = System.nanoTime();
        sum = 0L;
        for (long l : list) sum += l;
        avg = (double) sum / 10_000_000;
        System.out.println("Average (Sequential): " + avg);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " ns");
    }

    public static void testAverageStream() {
        List<Long> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10_000_000; i++) {
            list.add((long) rand.nextInt(500));
        }

        // ForkJoin com parallelStream
        long start = System.nanoTime();
        double avg = list.parallelStream()
                .mapToLong(Long::longValue)
                .average()
                .getAsDouble();
        System.out.println("Average (Parallel Stream): " + avg);
        System.out.println("Time: " + (System.nanoTime() - start) + " ns");

        // Sequencial
        start = System.nanoTime();
        long sum = 0L;
        for (long l : list) sum += l;
        avg = (double) sum / 10_000_000;
        System.out.println("Average (Sequential): " + avg);
        System.out.println("Time: " + (System.nanoTime() - start) + " ns");
    }

    public static void main(String[] args) throws Exception {

        ForkJoinPool pool = new ForkJoinPool();
        int val = 10;

        Fibonacci f = new Fibonacci(val);
        int result = pool.invoke(f);

        System.out.println("Fibonacci of " + val + " is " + result + ".\n");

        testAverage();

        System.out.println("\nStream: ");
        testAverageStream();

    }
}
