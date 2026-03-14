## Introduction to concurrency in Java. Threads and shared objects

Create an application that simulates a multithreaded ordering application in which **multiple order takers**, each
running the application in a separate thread, generate orders (just a *number*) that are added to the queue that runs in
the application’s main thread.

The orders are then handled by **multiple order-handling threads**, which remove orders from the
queue and display them in the console. One suggestion for the classes you should use is:

- **Order class**: Object that represents an order
- **OrderQueue class**: Uses LinkedList to implement a list of orders.
- **OrderTaker class**: creates and adds orders to the queue.
- **OrderHandler class**: removes orders from the queue.

Java offers builtin support for concurrency. One example of a class with builtin support for concurrency is
`ConcurrentLinkedQueue`.

Modify the solution for the former exercise using `ConcurrentLinkedQueue`.

---

### Perspective

The goal of this assignment has been to remember basic concepts of object-oriented programming and to introduce
concurrent programming in the *JAVA* language. In summary, upon competition you should understand:

- How to create threads.
- How to share memory between threads.
- How to coordinate access to the shared memory in order to maintain data integrity.