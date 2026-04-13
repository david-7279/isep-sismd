## ForkJoinPool and Recursive Problem Solving

1. **Implement the Fibonacci function using ForkJoinPool**.
   Your solution should recursively compute the Fibonacci of a given number using tasks submitted to a ForkJoinPool.

2. **Compare the performance of parallel and sequential approaches to compute the average of
   10,000,000 random numbers**.
   Generate a list of 10 million random numbers and compute the average using:
    * A ForkJoinPool-based parallel approach
    * A sequential loop

   Measure and compare the execution times of both approaches.

You can use the following Java code as a starting point:

```java
    public static void testAverage() {
    List<Long> list = new ArrayList<>();
    ForkJoinPool pool = new ForkJoinPool();
    Random rand = new Random();

    for (int i = 0; i < 10_000_000; i++) {
        list.add((long) rand.nextInt(500));
    }

    long start = System.nanoTime();
    SumTask task = new SumTask(list);
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

```

3. **Count files with a given extension using ForkJoinPool**.
   Write a program that counts the number of files with a given extension (e.g., ".txt") in one or more directory trees.
   For each subfolder found, create a new task using fork() and execute it using the pool.
   Example output:

```text
    "C:\Windows": 267 files found.
    "C:\Program Files": 1210 files found.
    "C:\Users\Jorge\Documents": 4 files found.
```

---

## Perspective

Upon completing this assignment, you should understand:

* How to use ForkJoinPool to solve recursive problems.
* The impact of data granularity on performance.
* The differences between creating, submitting, and executing tasks within ForkJoinPools.
