package fpb_customer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import juiceproducer.Juice_Interface;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class FPBCustomerActivator implements BundleActivator {
	
	InputStreamReader r = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(r);
	ServiceReference serviceReference;
	
	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Customer service starting\n");
		
		System.out.println("Products\n\nFruit\nJuice\nJam\nSalad\n\n");
		
		System.out.println("What type of Product You Need: ");
		String serviceType = br.readLine();
		
		System.out.println("Service: "+serviceType);
		
		if(serviceType.equalsIgnoreCase("Friut"))
		{
			serviceReference = context.getServiceReference(Juice_Interface.class.getName());
			Juice_Interface Friut = (Juice_Interface) context.getService(serviceReference);
	}
		}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Stopping customer service\n");
		context.ungetService(serviceReference);
	}

	public void serviceChanged(ServiceEvent ev) {
	}
}

		/* close the service tracker
		dictionaryServiceTracker.close();
		dictionaryServiceTracker = null;

		service = null;
		fContext = null;
	}

	public void serviceChanged(ServiceEvent ev) {
		ServiceReference<?> sr = ev.getServiceReference();
		switch(ev.getType()) {
			case ServiceEvent.REGISTERED:
			{
				Dictionary dictionary = (Dictionary) fContext.getService(sr);
				service.registerDictionary(dictionary);
			}
			break;
			case ServiceEvent.UNREGISTERING:
			{
				Dictionary dictionary = (Dictionary) fContext.getService(sr);
				service.unregisterDictionary(dictionary);
			}
			break;
		}*/
	

