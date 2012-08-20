package edu.wustl.cse.harmsk.templatevariables.core;

public class RegisterResolvers implements org.eclipse.ui.IStartup {

	private static final String JAVA_PLUGIN_ID = "org.eclipse.jdt.ui";

	public void earlyStartup() {
		// check if plug-in org.eclipse.jdt.ui is already active
		final org.osgi.framework.Bundle bundle = org.eclipse.core.runtime.Platform.getBundle(JAVA_PLUGIN_ID);
		if (bundle != null && bundle.getState() == org.osgi.framework.Bundle.ACTIVE) {
			// register resolvers
			registerResolvers();
		} else {
			// register listener to get informed, when plug-in becomes active
			final org.osgi.framework.BundleContext bundleContext = Activator.getContext();
			bundleContext.addBundleListener(new org.osgi.framework.BundleListener() {
				public void bundleChanged(final org.osgi.framework.BundleEvent pEvent) {
					final org.osgi.framework.Bundle bundle2 = pEvent.getBundle();
					if (!bundle2.getSymbolicName().equals(JAVA_PLUGIN_ID)) {
						return;
					}
					if (bundle2.getState() == org.osgi.framework.Bundle.ACTIVE) {
						registerResolvers();
						bundleContext.removeBundleListener(this);
					}
				}
			});
		}
	}

	private void registerResolvers() {
		final org.eclipse.jface.text.templates.ContextTypeRegistry codeTemplateContextRegistry = org.eclipse.jdt.internal.ui.JavaPlugin.getDefault().getCodeTemplateContextRegistry();
		final java.util.Iterator<?> ctIter = codeTemplateContextRegistry.contextTypes();
		while (ctIter.hasNext()) {
			final org.eclipse.jface.text.templates.TemplateContextType contextType = (org.eclipse.jface.text.templates.TemplateContextType) ctIter.next();
			contextType.addResolver(new GitVariableCommentResolver());
		}
	}
}
