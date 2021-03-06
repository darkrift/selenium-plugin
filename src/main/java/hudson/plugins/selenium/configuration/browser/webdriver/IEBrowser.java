package hudson.plugins.selenium.configuration.browser.webdriver;

import hudson.Extension;
import hudson.plugins.selenium.configuration.browser.BrowserDescriptor;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.export.Exported;

public class IEBrowser extends WebDriverBrowser {
	
	private String server_binary;
	
	@DataBoundConstructor
	public IEBrowser(int maxInstances, String version, String server_binary) {
		super(maxInstances, version, "internet explorer");
		this.server_binary = server_binary;
	}
	
	@Exported
	public String getServerBinary() {
		return server_binary;
	}
	
    @Extension
    public static class DescriptorImpl extends WebDriverBrowserDescriptor {

		@Override
		public String getDisplayName() {
			return "Internet Explorer";
		}

    }
}
