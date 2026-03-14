## Explicit Locks Instead of Semaphores

Modify the [previous exercise](../semaphores/readme.md) to use **explicit locks** (Java's `ReentrantLock`)
instead of semaphores.

---

### Requirements:

- Replace the semaphore with a ReentrantLock to control access to the tickets object.
- Use `lock()` and `unlock()` to protect critical sections.
- Ensure that sellers can be **interrupted safely** without causing deadlocks.
- Use a `try-finally` block to guarantee proper unlocking of resources.