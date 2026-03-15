# 📊 Concurrent Content Interaction System

## Overview

This project simulates a **high-concurrency** content interaction system, similar to those used in modern social media
platforms.

Multiple users interact with pieces of content concurrently by performing actions such as:

- liking posts
- viewing posts
- reacting to content

The goal of this project is to explore lock-free concurrency mechanisms in Java, using **atomic variables** to safely
update shared state without explicit locks.

This approach improves **performance**, **scalability**, and **throughput** in systems with high levels of concurrent
access.

---

## 🎯 Objectives

The main goals of this project are:

- Understand how **atomic variables** work in concurrent environments.
- Simulate **thousands of concurrent user interactions**.
- Avoid race conditions without using traditional locks.
- Explore **lock-free programming patterns**.

---

## 🧠 Key Concepts Covered

This project focuses on the following concurrency concepts:

### Atomic Variables

Atomic variables guarantee **thread-safe updates** without requiring explicit synchronization.

Examples:

- `AtomicInteger`
- `AtomicLong`
- `AtomicReference`

---

### Lock-Free Programming

Instead of blocking threads using locks, the system relies on **atomic operations** to safely update shared values.

Benefits:

- reduced thread contention
- improved scalability
- higher throughput under load

---

### Compare-And-Swap (CAS)

Atomic operations internally rely on a technique called:

**CAS — Compare And Swap**

This mechanism ensures that updates occur **only if the expected value matches the current state**, allowing safe
concurrent modifications.

---

## 🏗 System Architecture

The project follows a simple layered structure.

```text
content-interaction-system
│
├─ model
│   └─ Content
│
├─ service
│   └─ InteractionService
│
├─ thread
│   └─ UserInteraction
│
└─ Main
```

---

## 📦 Components

### Content

Represents a piece of content (post, video, article).

It maintains interaction counters such as:

- number of views
- number of likes
- number of reactions

These counters are implemented using **atomic variables** to allow safe concurrent updates.

---

### InteractionService

Handles the interaction logic between users and content.

Responsibilities include:

- registering views
- adding likes
- updating interaction statistics

The service acts as an **orchestrator**, delegating atomic updates to the content model.

---

### UserInteraction (Thread)

Simulates a user interacting with the platform.

Each thread performs random actions such as:

- viewing content
- liking content
- reacting to content

This creates a **highly concurrent environment** where many threads attempt to update shared counters simultaneously.

---

### Main

Entry point of the application.

Responsible for:

- creating the content objects
- spawning multiple user threads
- starting the simulation

The program runs continuously, generating concurrent interactions.

---

## ⚙️ Simulation Behaviour

The simulation represents multiple users interacting with the same content.

Typical flow:

```text
User thread
     ↓
generate interaction
     ↓
InteractionService processes action
     ↓
Content counters updated atomically
```

Because the counters are atomic, **no race conditions occur even under heavy concurrency**.

---

## 🚀 Example Scenario

Imagine:

```text
1 video
5000 users watching simultaneously
```

Each user can:

- view the video
- like it
- react to it

Atomic variables ensure that the counters remain **consistent and accurate**, even when thousands of updates occur
concurrently.

---

## 📈 Why Atomic Instead of Locks?

Using locks in this scenario could lead to:

- heavy thread contention
- reduced performance
- blocked threads

Atomic operations allow the system to remain:

```text
non-blocking
highly scalable
efficient under load
```

This makes them ideal for **simple shared counters**.

---

## 🧪 Experimentation Ideas

To explore concurrency behaviour, you can experiment with:

- increasing the number of user threads
- measuring interaction throughput
- comparing performance with lock-based implementations
- tracking how atomic operations scale under heavy load

---

## 🎓 Learning Outcomes

After completing this project, you should understand:

- how atomic variables work
- when to use lock-free concurrency
- how to design high-throughput concurrent systems
- the trade-offs between locks vs atomic operations