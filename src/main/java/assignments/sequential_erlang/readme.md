# Sequential Erlang

## 1. Basic Problems

Create the following simple functions:

* **square/1** – Returns the square of a given number.
* **temp_convert/1** – Converts a Fahrenheit temperature to Celsius using the formula: `C = 5(F - 32)/9`.

---

## 2. Recursive Problems

Define the following recursive functions:

* **factorial/1** – Computes the factorial of a given number.
* **fib/1** – Computes the Fibonacci number at the given position.

---

## 3. List Operations

Implement the following functions that operate on lists:

* **count/1** – Returns the number of elements in a list.
* **member/2** – Returns true if a given element is in the list, false otherwise.
* **delete/2** – Removes a given element from a list.
* **reverse/1** – Returns a new list with the elements of the original list in reverse order.
* **average/1** – Calculates the average of a list of numbers.

---

## 4. Using Guards

Write functions that use guards to restrict input or guide execution:

* **sum_max/2** – Given two lists, finds the maximum value in each and returns their sum.
* **int/1** – Given a list of numbers (integers and floats), returns a new list with only the integers.

---

## 5. Working with Tuples

Given a list of tuples representing students (name and grade in SISMD), implement:

* **grades/1** – Returns:
    * The average grade,
    * The name and grade of the highest-scoring student,
    * The name and grade of the lowest-scoring student.

---

## Perspective

This assignment introduces fundamental concepts in sequential programming using the functional language Erlang. Upon
completion, you should understand:

* How variables work in Erlang.
* How to define functions and organize them into modules.
* How to use guards to filter function inputs.
* How to manage collections using lists and tuples.
* The differences between lists and tuples.

