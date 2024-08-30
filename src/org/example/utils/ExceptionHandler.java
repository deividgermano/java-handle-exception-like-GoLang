package org.example.utils;

import java.util.Optional;

public class ExceptionHandler {

	public static <T> Pair<T, Optional<Exception>> tryExecuteWithResultAndException(ThrowableFunction<T> function) {
        try {
			return new Pair<>(function.apply(), Optional.empty());
        } catch (Exception e) {
			return new Pair<>(null, Optional.of(e));
        }
    }

	public static <T> Optional<Exception> tryExecuteWithException(ThrowableRunnable runnable) {
		try {
			runnable.run();
			return Optional.empty();
		} catch (Exception e) {
			return Optional.of(e);
		}
	}
}