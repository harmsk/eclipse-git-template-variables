package edu.wustl.cse.harmsk.eclipse.gittemplatevariables;

public class GitVariableResolverHelper {

	@SuppressWarnings({ "unchecked", "restriction" })
	public static void resolve(org.eclipse.jface.text.templates.TemplateVariable variable, org.eclipse.jface.text.templates.TemplateContext context) {
		final java.util.List<String> params = variable.getVariableType().getParams();
		if (params.isEmpty()) {
			return;
		}
		final String gitKey = params.get(0);
		if ( gitKey == null || gitKey.length() == 0 ) {
			return;
		}

		// Get git's config
		org.eclipse.core.resources.IProject project = ((org.eclipse.jdt.internal.corext.template.java.CodeTemplateContext) context).getJavaProject().getProject();
		org.eclipse.egit.core.project.RepositoryMapping mapping = org.eclipse.egit.core.project.RepositoryMapping.getMapping((org.eclipse.core.resources.IProject) project);
		org.eclipse.jgit.lib.Repository repository = null;
		if (mapping != null) {
			repository = mapping.getRepository();
		}
		if (repository == null) {
			return;
		}
		org.eclipse.jgit.lib.StoredConfig config = repository.getConfig();
		if ( config == null ) {
			return;
		}

		// Get the value of the key
		final String[] splits = gitKey.split("\\.");
		String section = null;
		String subSection = null;
		String name = null;
		if ( splits.length == 3 ) {
			section = splits[0];
			subSection = splits[1];
			name = splits[2];
		} else if ( splits.length == 2 ) {
			section = splits[0];
			name = splits[1];
		} else {
			return;
		}

		String gitValue = config.getString(section, subSection, name);
		if ( gitValue != null ) {
			variable.setValue( gitValue );
		}
	}
}
