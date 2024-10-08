# java-handle-exception-like-GoLang

A Project to Handling errors in Java using a pattern like this is somewhat similar to Go's approach. It allows you to handle exceptions more cleanly and expressively without the need for extensive try-catch blocks.

## Table of Contents

- [Description](#description)
- [Code for Fun and Learning](#fun)
- [For Educational Use Only](#foreducational)

## Description

This project introduces an ExceptionHandler utility class for simplifying error handling in Java. It provides methods that allow you to execute functions and handle exceptions without extensive use of try-catch blocks. The utility uses functional programming concepts and Java's Optional to manage results and exceptions cleanly and efficiently, improving code readability and maintainability.

# Example Code
Here’s an example of how to use the ExceptionHandler methods in your code:

```
package org.example;

import static org.example.utils.ExceptionHandler.tryExecuteWithException;
import static org.example.utils.ExceptionHandler.tryExecuteWithResultAndException;

import java.util.Optional;

import org.example.utils.Pair;

public class Example {

	public static void main(String[] args) {
		Example example = new Example();

		// Case 1: Successful division
		Pair<Integer, Optional<Exception>> result = example.divide(10, 2);
        result.getRight().ifPresentOrElse(
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Result: " + result.getLeft())
            );

		// Case 2: Division by zero
		Pair<Integer, Optional<Exception>> resultWithError = example.divide(10, 0);
        resultWithError.getRight().ifPresentOrElse(
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Result: " + resultWithError.getLeft())
            );

		// Case 3: void function
		Optional<Exception> resultVoid = example.voidFunction(false);
		resultVoid.ifPresent(error -> System.out.println("Error: " + error.getMessage()));

		// Case 4: void function with Exception
		Optional<Exception> resultVoidWithError = example.voidFunction(true);
		resultVoidWithError.ifPresent(error -> System.out.println("Error: " + error.getMessage()));
	}

	public Pair<Integer, Optional<Exception>> divide(int numerator, int denominator) {
		return tryExecuteWithResultAndException(() -> numerator / denominator);
	}

	public Optional<Exception> voidFunction(Boolean shouldThrowException) {
		return tryExecuteWithException(() -> {
			if (shouldThrowException)
				throw new Exception("Exception on performing an action");
			else
				System.out.println("Performing an action.");
		});
	}
}
```
## Code for Fun and Learning

This code is designed with a fun and learning mindset. Enjoy experimenting and discovering new things!

## For Educational Use Only

This code is intended for educational purposes and should not be used in production environments.
