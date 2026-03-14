# Concurrent Programming Problems

## Online Banking System

Implement an online banking system where multiple users can access their accounts concurrently.

The system must support transfers between accounts while ensuring data consistency and avoiding race conditions.

---

### Requirements:

- Users can perform transactions such as deposits, withdrawals, and transfers between accounts.
- Each user has a unique account with a balance.
- Multiple users can access the system simultaneously.
- Transfers should lock both accounts to prevent inconsistent states.

### Required Implementations:

- **Synchronized-Based Solution**: Implement a version using Java's synchronized keyword to ensure thread safety.
- **TryLock-Based Solution**: Implement a version using tryLock to avoid potential deadlocks by timing out if locks
  cannot be acquired.

---

### Question

Do you think that atomic variables such as AtomicInteger could be used to implement a banking system? Justify your
answer.

AtomicInteger garante atomicidade de:

- balance++
- balance--

Mas transferência faz:

- A.balance -= amount
- B.balance += amount

Ou seja:

- duas variáveis
- duas operações

AtomicInteger **não garante atomicidade entre duas contas**.

Logo:

> AtomicInteger sozinho **não é suficiente para implementar um sistema bancário correto**.

---

### Perspective

The objective of these problems is to enhance your understanding of communication and synchronization mechanisms in
concurrent programming. Upon completion, you should be able to:

- Design and implement multi-threaded applications.
- Handle synchronization challenges effectively.
- Use Java concurrency utilities to improve performance and prevent deadlocks.