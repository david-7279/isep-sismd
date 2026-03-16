# 🚦 Concurrent API Rate Limiter System

## 📌 Overview

This project simulates a **Concurrent API Rate Limiter**, a common mechanism used in backend systems to control how many
requests clients can send to an API within a specific time window.

Rate limiting is essential for:

- 🛡 Preventing API abuse
- ⚡ Protecting infrastructure from overload
- ⚖ Ensuring fair usage among clients
- 🔒 Maintaining system stability

The system simulates multiple clients making requests concurrently while the server enforces a **maximum number of
allowed requests per time window**.

---

# 🏗 System Architecture

The project is structured using a layered architecture commonly used in backend applications.

```text
rate_limiter_system
│
├── model
│ └── RateLimiter
│
├── service
│ └── ApiService
│
├── thread
│ └── ApiClient
│
└── Main
```

Each layer has a clear responsibility to keep the system modular and maintainable.

---

# 🧩 Core Components

## 📦 RateLimiter (Model)

The `RateLimiter` is responsible for enforcing request limits.

It maintains the internal state required to determine whether a request should be **accepted** or **rejected**.

### Responsibilities

- 📊 Track the number of requests within the current time window
- 🔄 Reset counters when a new time window starts
- 🔐 Ensure thread-safe updates under heavy concurrency

### Internal State

The rate limiter tracks:

- `maxRequests` → maximum allowed requests
- `timeWindow` → duration of the rate limiting window
- `currentRequests` → current number of requests in the window
- `windowStart` → timestamp when the window started

### Concurrency Strategy

The system uses **atomic operations** to avoid race conditions when multiple threads update counters simultaneously.

---

## ⚙️ ApiService (Service Layer)

The `ApiService` simulates the backend API.

Each request sent by a client passes through the service layer where the rate limiter determines whether the request can
be processed.

### Request Flow

```text
Client Request
│
▼
RateLimiter.checkRequest()
│
├── ✅ Allowed → Process request
│
└── ❌ Rejected → Rate limit exceeded
```

### Responsibilities

- 📥 Receive requests from clients
- 🧠 Delegate rate control to the rate limiter
- ⚙ Process accepted requests
- 🚫 Reject requests when limits are exceeded

---

## 🧵 ApiClient (Thread Layer)

Each `ApiClient` represents a client interacting with the API.

Multiple client threads run concurrently and continuously attempt to send requests.

### Responsibilities

- 👤 Simulate API users
- 🎲 Generate requests at random intervals
- 📡 Send requests to the `ApiService`

### Thread Behavior

Each client thread repeatedly:

1️⃣ Sends a request to the API  
2️⃣ Waits a short random time  
3️⃣ Repeats the process

This generates **high concurrency and contention** for the rate limiter.

---

## 🚀 Main (Application Entry Point)

The `Main` class initializes the system and launches the simulation.

### Responsibilities

- 🏗 Create the rate limiter
- ⚙ Initialize the API service
- 👥 Spawn multiple client threads
- ⏱ Run the simulation for a fixed period
- 📊 Collect and display metrics

---

# ⏳ Rate Limiting Strategy

This project implements a **Fixed Window Rate Limiting algorithm**.

### How It Works

The algorithm divides time into fixed intervals.

Example:

```text
Window Duration: 1 second
Max Requests: 5
```

Within each second:

```text
Request 1 → allowed
Request 2 → allowed
Request 3 → allowed
Request 4 → allowed
Request 5 → allowed
Request 6 → rejected
```

Expected result:

```text
6 requests
```

Incorrect result:

```text
5 requests
```

The system solves this problem using **atomic operations**, which guarantee that updates to shared counters occur safely
under concurrency.

---

# 📊 Metrics Collected

During execution, the system tracks:

- 📈 Total requests
- ✅ Accepted requests
- ❌ Rejected requests

Example final output:

```text
==== API METRICS ====

Total Requests: 842
Accepted Requests: 500
Rejected Requests: 342
```

These metrics help visualize how the rate limiter behaves under load.

---

# 🧠 Key Concepts Demonstrated

This project demonstrates important concurrent programming concepts.

### 🔹 Atomic Operations

Thread-safe counters without using locks.

### 🔹 Time Window Control

Managing request limits within defined intervals.

### 🔹 Thread Contention

Multiple threads competing to update shared state.

### 🔹 High Concurrency Simulation

Testing systems under heavy load.

---

# 🌍 Real-World Applications

Rate limiting mechanisms are widely used in modern backend infrastructure, including:

- 🌐 API gateways
- ☁ Cloud platforms
- 💳 Payment processing APIs
- 🔐 Authentication services
- 📦 Content delivery networks

They help ensure systems remain stable even under heavy traffic.

---

# 🖥 Simulation Example

During execution, the terminal may display events such as:

```text
Client-1 → request accepted
Client-2 → request accepted
Client-3 → request accepted
Client-4 → request accepted
Client-5 → request accepted
Client-6 → request rejected (rate limit exceeded)
Client-7 → request rejected (rate limit exceeded)
```

This behavior illustrates how the rate limiter controls request throughput in real time.

---

# 🎓 Learning Outcomes

By implementing this project, you gain practical experience with:

- 🧵 Designing concurrent systems
- 🔐 Managing shared state safely
- ⚡ Simulating high-load environments
- 🧠 Understanding backend infrastructure patterns
- 🚦 Applying rate limiting strategies used in production systems

---

# 🔮 Possible Extensions

The system can be extended with more advanced rate limiting strategies such as:

- Sliding Window Rate Limiter
- Token Bucket Algorithm
- Leaky Bucket Algorithm

Additional improvements may include:

- 📊 Metrics dashboards
- 📈 Monitoring systems
- ⚙ Dynamic rate limit configuration
- 🌍 Distributed rate limiting

---

# 📚 Summary

This project demonstrates how to build a **thread-safe rate limiter** capable of handling multiple concurrent clients
while enforcing request limits within a fixed time window.

It serves as a practical introduction to **concurrency control in backend systems** and reflects patterns commonly used
in production-grade API infrastructure.