# Introduction to Thread Pools

In these exercises, we will explore how to use the Executor framework in Java to efficiently manage a pool of threads.
The goal is to sum a given array of integers in parallel using an Executor with a fixed number of threads.

---

## Exercise 1: Using Executors with Runnable

Implement a solution that divides the sum computation into multiple tasks, executed in parallel using a fixed thread
pool.

1. Create a class Sum that implements Runnable and performs the following:
    - Accepts an array of integers, along with start and end indices.
    - Computes the sum of the elements within the specified range.
    - Prints the computed partial sum.
    - You can use the following code as a starter for this:

      ```java
      public class PartialSum implements Runnable {
          private final int from;
          private final int to;
      
          PartialSum(int _from, int _to, int[] vec) {
          ...
          }
      
          @Override
          public void run() {
              int partialSum = 0;
              System.out.println(Thread.currentThread().getName() + " starting to sum from " + from + " to " + to);
              for (int i = from; i < to; i++)
                  partialSum += vec[i];
              System.out.println(Thread.currentThread().getName() + " adding " + partialSum + " to total");
          }
      }
      ```

2. Use a fixed-size thread pool with a predefined number of threads (e.g., 5).
3. 3Divide the array into a number of partitions greater than the number of available threads (e.g., 10 partitions).
4. Instantiate and submit a Sum task for each partition to the Executor. You can use the following starter code for
   this:

```java
    public class Parallel {
    private static final int N_PARTITIONS = 10;
    private static final int N_THREADS = 5;
    private static final int VEC_SIZE = 2000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
            ...

        int sizePart = VEC_SIZE / N_PARTITIONS;

        for (int i = 0; i < N_PARTITIONS; i++) {
            int from = i * sizePart;
            int to = (i + 1) * sizePart;
            Runnable task = new PartialSum(from, to, data);
            System.out.println("Creating task to sum from " + from + " to " + to);
            executor.submit(task);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            executor.shutdownNow();
        }

        System.out.println("All threads have finished.");

    }

}
```