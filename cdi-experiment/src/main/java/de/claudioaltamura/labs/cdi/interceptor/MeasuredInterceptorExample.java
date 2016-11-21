package de.claudioaltamura.labs.cdi.interceptor;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class MeasuredInterceptorExample {

	public static void main(String[] args) throws InterruptedException {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		Service service = container.instance().select(Service.class, Service.class.getAnnotations()).get();
		service.execute();
		
		container.shutdown();
	}
}
