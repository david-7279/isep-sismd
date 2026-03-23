package main.java.assignments.introduction_to_thread_pools.thread;

import java.util.concurrent.Callable;

public class CallablePartialSum implements Callable<Integer> {

    private final int from;
    private final int to;
    private final int[] vec;

    public CallablePartialSum(int _from, int _to, int[] _vec) {
        this.from = _from;
        this.to = _to;
        this.vec = _vec;
    }

    @Override
    public Integer call() {
        int partialSum = 0;

        for (int i = from; i < to; i++) {
            partialSum += vec[i];
        }

        System.out.println(Thread.currentThread().getName() +
                " computed partial sum: " + partialSum
        );

        return partialSum;
    }
}
