package main.java.assignments.fork_join_pool_and_recursive_problem.service;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {

    public final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        Fibonacci f1 = new Fibonacci(n - 1);
        Fibonacci f2 = new Fibonacci(n - 2);
        f1.fork();
        f2.fork();
        return f2.join() + f1.join();
    }
}
