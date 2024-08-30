package org.example.utils;

@FunctionalInterface
public interface ThrowableRunnable {
	void run() throws Exception;
}