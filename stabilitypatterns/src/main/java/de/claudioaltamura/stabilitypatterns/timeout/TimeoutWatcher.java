package de.claudioaltamura.stabilitypatterns.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeoutWatcher {
	
	private ExecutorService executorService = Executors.newSingleThreadExecutor();
	
	public <T> T callWithTimeout(Callable<T> callable, int timeoutInSeconds) throws InterruptedException, ExecutionException, TimeoutException {
		Future<T> task = executorService.submit(callable);
	
		return task.get(timeoutInSeconds, TimeUnit.SECONDS);		
	}

}
