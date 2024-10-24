<div align="center">

# Java Concurrency and Multithreading 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Threads](https://img.shields.io/badge/Threads-000000?style=for-the-badge&logo=Threads&logoColor=white)
![](https://img.shields.io/badge/JetBrains-000000.svg?style=for-the-badge&logo=JetBrains&logoColor=white)
![](https://img.shields.io/badge/Apache%20Maven-C71A36.svg?style=for-the-badge&logo=Apache-Maven&logoColor=white)
</div>

This repository contains a collection of exercises focused on Java multithreading and concurrency concepts. These exercises are designed to help you understand and implement various threading techniques in Java.

## Table of Contents

- [Introduction](#introduction)
- [Multithreading Basics](#multithreading-basics)
- [Concurrency in Java](#concurrency-in-java)
- [Parallelism](#parallelism)

## Introduction

Multithreading is a core concept in Java that allows concurrent execution of two or more threads. It enables efficient use of CPU resources, improving application performance, especially in tasks that are I/O bound or CPU intensive. Concurrency, on the other hand, is the ability of an application to execute multiple tasks simultaneously, potentially improving responsiveness.

Multithreading is a specific implementation of concurrency that involves multiple threads of execution within a single process. Each thread can run concurrently with others, sharing the same resources (like memory).

## Multithreading Basics

![image](https://github.com/user-attachments/assets/2a6e12d1-1849-409c-a9d7-02e85612f758)

### What is a Thread?

A thread is a lightweight process that can run independently of others. In Java, a thread can be created by either:

1. Extending the `Thread` class
2. Implementing the `Runnable` interface

### Key Concepts

- **Thread Lifecycle**: A thread can be in one of several states: New, Runnable, Blocked, Waiting, Timed Waiting, or Terminated.
- **Synchronization**: To avoid conflicts when multiple threads access shared resources, synchronization is crucial. Java provides mechanisms like `synchronized` methods and blocks, and the `Lock` interface.

![image](https://github.com/user-attachments/assets/1deb3f68-404a-46d4-8b8b-6493cc857e6d)

### Process vs. Threads

Processes and threads are two basic execution units; while process refers to a Java Virtual Machine execution instance, the threads are a subset of the process. 

A Java Virtual Machine starts with a single thread by default which is called the main thread. And additional threads can be created by either;

    1. Implementing the Runnable interface
    2. implementing the Callable interface.
    3. Extending the Thread class

### Methods of Multithreading in Java

| Method                | Description                                                |
|-----------------------|------------------------------------------------------------|
| `start()`             | Starts the execution of the thread.                        |
| `run()`               | Contains the code that is executed when the thread runs.   |
| `sleep(long millis)`  | Pauses the execution of the current thread for a specified time. |
| `join()`              | Waits for the thread to die, allowing one thread to wait for another to complete. |
| `yield()`             | Suggests to the thread scheduler that the current thread is willing to yield its current use of the CPU. |
| `interrupt()`         | Interrupts a thread that is in a sleeping or waiting state. |
| `setPriority(int newPriority)` | Changes the priority of the thread, affecting its execution order. |
| `getId()`             | Returns the unique identifier of the thread.              |
| `getName()`           | Returns the name of the thread.                            |
| `isAlive()`           | Tests whether the thread is alive (i.e., has been started and has not yet died). |
## Why Multi threads?

### Focus :
- The focus of multithreading is on the execution of multiple threads, which can be managed by the system's scheduler. Each thread can perform a separate task, allowing for parallelism if the hardware supports it (e.g., multiple CPU cores).
### Benefits:

1. **Improved Performance**
   - **Parallelism**: Allows multiple threads to run concurrently, leveraging multi-core processors for significant performance improvements.
   - **Responsiveness**: Keeps applications responsive by performing background tasks without freezing the user interface.

2. **Resource Sharing**
   - **Efficient Use of Resources**: Threads within the same process share memory space, allowing efficient communication and data sharing.

3. **Better System Utilization**
   - **I/O Bound Tasks**: While one thread waits for I/O operations, other threads can continue executing, making better use of CPU time.

4. **Simplified Program Structure**
   - **Separation of Concerns**: Breaks down complex tasks into smaller, manageable parts that can run independently, leading to cleaner and more maintainable code.
   - **Modularity**: Different components of an application can be handled by separate threads, resulting in more organized designs.

5. **Enhanced Scalability**
   - **Handling Multiple Requests**: Enables servers to handle multiple client requests simultaneously, improving scalability and throughput.
   - **Dynamic Load Balancing**: Threads can adapt to workload changes, responding better to varying demands.

6. **Real-time Applications**
   - **Concurrent Processing**: Crucial for processing tasks concurrently in real-time systems like gaming, simulations, or financial systems.

## Use Cases

- **Web Servers**: Handling multiple client requests simultaneously.
- **Gaming Applications**: Managing game state, rendering graphics, and processing user inputs concurrently.
- **Data Processing**: Parallel processing of large datasets to improve throughput and reduce processing time.
- **Mobile Applications**: Keeping user interfaces responsive while performing background operations.

## Concurrency in Java
<div align="center">
  
![image](https://github.com/user-attachments/assets/bab8c4e3-290f-410a-93c1-8b0750d635d0)
</div>

### Definition
- Concurrency refers to the ability of a system to handle multiple tasks at the same time. It does not necessarily mean that tasks are being executed simultaneously; rather, it means that tasks are being managed in such a way that they make progress over time.
Concurrency in Java is facilitated through various features:

- **Executors**: The `java.util.concurrent` package includes the `Executor` framework, which simplifies thread management.
- **Synchronization Utilities**: Classes such as `CountDownLatch`, `CyclicBarrier`, and `Semaphore` help manage concurrent tasks.
- **Concurrent Collections**: These collections, such as `ConcurrentHashMap`, are designed to be used safely by multiple threads without external synchronization.

### Relationship Between Concurrency and Multithreading
- **Overlap**: While all multithreading is a form of concurrency (because multiple threads can be executed simultaneously), not all concurrency involves multithreading. Concurrency can also be achieved through other means, such as asynchronous programming or using multiple processes.
- **Example of Relationship**: In a multithreaded application, you might have several threads that work on different tasks concurrently. For instance, one thread could handle user input, while another thread processes data. Here, concurrency is achieved through multithreading.

## Parallelism
<div align="center">
  
  ![image](https://github.com/user-attachments/assets/9d653e25-9ba4-4f2e-99df-8e8b7eccd57d)

</div>

### Definition:
  Parallelism, refers to the simultaneous execution of multiple tasks or processes. It requires multiple processing units (e.g., CPU cores) to run tasks at the exact same time.
- **Key Characteristics**:
  - Tasks are executed simultaneously, effectively dividing work across available processors.
  - Parallelism is a subset of concurrency; all parallel executions are concurrent, but not all concurrent executions are parallel.

### Concurrency vs Parallelism:
           
#### Visual Representation of Concurrency

| Time | Task A        | Task B        | Task C        |
|------|---------------|---------------|---------------|
| 0    | Start         |               |               |
| 1    | Running       |               |               |
| 2    |               | Start         |               |
| 3    | Running       | Running       |               |
| 4    |               |               | Start         |
| 5    |               | Running       | Running       |

In this diagram, tasks are managed concurrently but may not run at the same time.

---

#### Visual Representation of Parallelism

| Time | Task A        | Task B        | Task C        |
|------|---------------|---------------|---------------|
| 0    | Start         |               |               |
| 1    | Running       | Running       |               |
| 2    | Running       | Running       | Running       |

In this diagram, tasks are executed in parallel, utilizing multiple processors to run simultaneously.

- **Concurrency** is about dealing with lots of tasks at once and may not require them to be executed simultaneously. It is primarily concerned with managing the execution flow.
- **Parallelism** is about doing lots of tasks simultaneously, requiring multiple processing units to achieve this.
  
![image](https://github.com/user-attachments/assets/a92d323f-da55-4316-afd1-a7b65635587d)

# Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue if you have suggestions for improvements or new exercises.
