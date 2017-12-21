package cn.com.example5;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Activator implements BundleActivator, ServiceListener {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting to listen for service events.");
        bundleContext.addServiceListener(this);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        bundleContext.removeServiceListener(this);
        System.out.println("Stopped listening for service events.");
    }

    public void serviceChanged(ServiceEvent serviceEvent) {
        String[] objectClass = (String[]) serviceEvent.getServiceReference().getProperty("objectClass");
        if (serviceEvent.getType() == ServiceEvent.REGISTERED) {
            System.out.println("Ex1: Service of type " + objectClass[0] + " registered.");
        } else if (serviceEvent.getType() == ServiceEvent.UNREGISTERING) {
            System.out.println("Ex1: Service of type " + objectClass[0] + " unregistered.");
        } else if (serviceEvent.getType() == ServiceEvent.MODIFIED) {
            System.out.println("Ex1: Service of type " + objectClass[0] + " modified.");
        }
    }
}