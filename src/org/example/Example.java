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