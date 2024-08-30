package org.example.utils;

@FunctionalInterface
public interface ThrowableFunction<T> {
	T apply() throws Exception;
}