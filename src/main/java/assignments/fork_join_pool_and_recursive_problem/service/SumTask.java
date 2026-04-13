package main.java.assignments.fork_join_pool_and_recursive_problem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    List<Long> list = new ArrayList<>();
    private int start;
    private int end;

    public SumTask(List<Long> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    // Se a lista for pequena o suficiente (ex: menos de 1000 elementos) — soma diretamente
    // Senão — divide em duas metades e faz fork
    @Override
    protected Long compute() {

        // Lista pequena
        if ((end - start) < 1000) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += list.get(i);
            }

            return sum;

        } else {

            int middle = (start + end) / 2;
            SumTask task1 = new SumTask(list, start, middle);
            SumTask task2 = new SumTask(list, middle, end);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
