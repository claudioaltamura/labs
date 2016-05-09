package de.claudioaltamura.stabilitypatterns.timeout;

import static org.junit.Assert.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;

public class TimeoutWatcherTest {

	private TimeoutWatcher timeoutWatcher;
	private int timeoutInSeconds = 5;

	@Before
	public void setUp()
	{
		timeoutWatcher = new TimeoutWatcher();
	}

	@Test
	public void noTimeout() throws InterruptedException, ExecutionException, TimeoutException
	{
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "hello";
			}
		};
		String actual = timeoutWatcher.callWithTimeout(callable, timeoutInSeconds);
		String expected = "hello";
		
		assertEquals(expected, actual);
	}
	
	@Test(expected=TimeoutException.class)
	public void deviceDetectionTimeOut() throws InterruptedException, ExecutionException, TimeoutException
	{
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(timeoutInSeconds*1000 + 100);
				return "hello";
			}
		};
		timeoutWatcher.callWithTimeout(callable, timeoutInSeconds);
	}
	
}
