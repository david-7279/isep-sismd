package main.java.assignments.introduction_to_thread_pools.thread;

public class PartialSum implements Runnable {
    private final int from;
    private final int to;
    private final int[] vec;

    public PartialSum(int _from, int _to, int[] _vec) {
        this.from = _from;
        this.to = _to;
        this.vec = _vec;
    }

    @Override
    public void run() {
        int partialSum = 0;

        System.out.println(Thread.currentThread().getName() +
                " starting to sum from " + from +
                " to " + to
        );

        for (int i = from; i < to; i++) {
            partialSum += vec[i];
        }

        System.out.println(Thread.currentThread().getName() +
                " adding " + partialSum +
                " to total"
        );
    }
}
