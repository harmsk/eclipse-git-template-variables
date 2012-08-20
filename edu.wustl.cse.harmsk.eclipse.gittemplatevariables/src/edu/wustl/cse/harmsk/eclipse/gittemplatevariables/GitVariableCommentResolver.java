package edu.wustl.cse.harmsk.eclipse.gittemplatevariables;

public class GitVariableCommentResolver extends org.eclipse.jface.text.templates.TemplateVariableResolver {

	public GitVariableCommentResolver() {
		super("git_config", "Grab a value from git config. Example: git_user_name:git_config(user.name)");
	}

	@Override
	public void resolve(org.eclipse.jface.text.templates.TemplateVariable variable, org.eclipse.jface.text.templates.TemplateContext context) {
		GitVariableResolverHelper.resolve(variable, context);
	}
}
