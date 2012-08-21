eclipse-git-template-variables
==============================

Eclipse plug-in to access git config keys from java templates.

About
-----

This plugin allows you to access any git config key inside of a Java template from Eclipse. This can be useful if you want to match the @author with the git commit author. For example, instead of having change user.name java property in your eclipse.ini file, which will break other eclipse features like SSH, you can use this plugin to access the name of the current git user. Now there is no need to set -Duser.name in your eclipse.ini if your project is using git!

Installation
------------

Grab it from this update site: http://harmsk.github.com/eclipse-git-template-variables/updatesite

Usage
-----

Make sure your project is shared using Egit. From the templates editor, simply use the git_config variable.

Example:
<pre>
/**
 * @author ${git_user_name:git_config(user.name)} {git_user_email:git_config(user.email)}
 *
 * ${tags}
 */
</pre>