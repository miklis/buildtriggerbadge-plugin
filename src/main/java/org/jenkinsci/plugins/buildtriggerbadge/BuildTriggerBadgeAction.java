package org.jenkinsci.plugins.buildtriggerbadge;

import hudson.model.BuildBadgeAction;
import hudson.model.Cause;
import jenkins.model.Jenkins;

/**
 * Badge action of the build trigger cause.
 * 
 * @author Michael Pailloncy
 */
public class BuildTriggerBadgeAction implements BuildBadgeAction {

	private final Cause cause;

	/**
	 * Initialize causes of the build.
	 */
	public BuildTriggerBadgeAction(Cause cause) {
		this.cause = cause;
	}

	public String getTooltip() {
		return cause.getShortDescription();
	}

	// FIXME : useless?
	public static BuildTriggerBadgePlugin getPlugin() {
		return (BuildTriggerBadgePlugin) Jenkins.getInstance().getPlugin(BuildTriggerBadgePlugin.class);
	}

	// non use interface methods
	public String getIconFileName() {
		return null;
	}

	public String getDisplayName() {
		return "Trigger " + cause.getClass().getSimpleName() + " : " + getTooltip();
	}

	public String getUrlName() {
		return "";
	}

	public String getIcon() {
		return new IconFinder(cause).find();
	}
}
