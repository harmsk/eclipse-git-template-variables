package edu.wustl.cse.harmsk.templatevariables.core;

public class Activator implements org.osgi.framework.BundleActivator {

	private static org.osgi.framework.BundleContext context;

	static org.osgi.framework.BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(org.osgi.framework.BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(org.osgi.framework.BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
}
