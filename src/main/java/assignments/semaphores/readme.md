## Semaphores

Create an application that simulates a concurrent ticket selling system.
The number of tickets available is stored in a shared **tickets object**.

There may exist **N** different sellers attempting to sell tickets, each represented by a separate thread.
Implement a solution where **semaphores are used strictly for controlling access to the shared tickets object,
rather than simulating the ticket availability itself**.

---

### Requirements:

- Ensure that concurrent access to the tickets object is **safely managed**.
- Each seller must check ticket availability before proceeding with a sale.
- The solution must allow sellers to be **interrupted** safely.
- Demonstrate how semaphores help in avoiding race conditions while allowing multiple sellers to operate efficiently.