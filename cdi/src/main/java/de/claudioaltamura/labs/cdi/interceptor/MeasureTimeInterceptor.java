package de.claudioaltamura.labs.cdi.interceptor;

import java.util.concurrent.TimeUnit;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Measured
@Interceptor
public class MeasureTimeInterceptor {
	
	@AroundInvoke
	private Object intercept(InvocationContext ic) throws Exception {
		long start = System.nanoTime();
		Object obj = ic.proceed();
		long end = System.nanoTime();
		long durationInMs = TimeUnit.NANOSECONDS.toMillis(end - start);

		Logger log = LoggerFactory.getLogger(ic.getMethod().getDeclaringClass());
    	log.info(ic.getMethod().getName() + " - " + durationInMs + " ms"); 

		return obj;
	}

}