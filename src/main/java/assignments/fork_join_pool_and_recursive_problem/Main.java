package main.java.assignments.fork_join_pool_and_recursive_problem;

import main.java.assignments.fork_join_pool_and_recursive_problem.service.Fibonacci;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws Exception {

        ForkJoinPool pool = new ForkJoinPool();
        int val = 10;

        Fibonacci f = new Fibonacci(val);
        int result = pool.invoke(f);

        System.out.println("Fibonacci of " + val + " is " + result + ".");
    }
}
