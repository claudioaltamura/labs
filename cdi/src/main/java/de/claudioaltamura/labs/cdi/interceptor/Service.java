package de.claudioaltamura.labs.cdi.interceptor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Service {
	
	private Random random = new Random();

	@Measured
	public long execute() throws InterruptedException {
		
		//long computation
		TimeUnit.SECONDS.sleep(randomTime());
		
		return 0;
	}

	private long randomTime() {
	    return random.nextInt(10) + 1;
	}

}
