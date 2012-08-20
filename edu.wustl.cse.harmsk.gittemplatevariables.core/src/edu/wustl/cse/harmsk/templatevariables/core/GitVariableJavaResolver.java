package edu.wustl.cse.harmsk.templatevariables.core;

public class GitVariableJavaResolver extends org.eclipse.jface.text.templates.TemplateVariableResolver {
	@Override
	public void resolve(org.eclipse.jface.text.templates.TemplateVariable variable, org.eclipse.jface.text.templates.TemplateContext context) {
		GitVariableResolverHelper.resolve(variable, context);
	}
}
