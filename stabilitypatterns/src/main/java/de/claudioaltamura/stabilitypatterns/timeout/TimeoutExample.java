package de.claudioaltamura.stabilitypatterns.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeoutExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<String> task = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				long heavyTaskInMs = 6000;
				Thread.sleep(heavyTaskInMs);
				return "Hello Timeout";
			}
		});

		try {
			long timeoutInSeconds = 5;
			System.out.println(task.get(timeoutInSeconds, TimeUnit.SECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}		
	}

}
