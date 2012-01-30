package hudson.plugins.selenium;

import hudson.DescriptorExtensionList;
import hudson.Extension;
import hudson.model.Node;
import hudson.plugins.selenium.configuration.Configuration;
import hudson.plugins.selenium.configuration.ConfigurationDescriptor;
import hudson.plugins.selenium.configuration.InheritConfiguration;
import hudson.slaves.NodeProperty;
import hudson.slaves.NodePropertyDescriptor;

import java.util.ArrayList;
import java.util.List;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

/**
 * Marker property to ...
 *
 * @author Richard Lavoie
 */
@ExportedBean
public class NodePropertyImpl extends NodeProperty<Node> {
	
	private int port = 4444;
	Configuration configType;
	
    @DataBoundConstructor
    public NodePropertyImpl() {}
    
    @Exported
    public Configuration getConfigurationType() {
    	return configType;
    }
    
    @Exported
    public int getPort() {
    	return port;
    }
    
	public List<String> getUserArgs() {
		if (configType == null) return new ArrayList<String>();
		return null;
		//return configType.getLaunchingArguments();
	}

    @Extension
    public static class DescriptorImpl extends NodePropertyDescriptor {
        
    	@Override
        public String getDisplayName() {
            return "Enable Selenium Grid on this node";
        }
    	
    	public DescriptorExtensionList<Configuration,ConfigurationDescriptor> getTypes() {
    		return Configuration.all();
    	}
    	
    	/**
    	 * @return default configuration for nodes
    	 */
    	public Configuration getDefaultConfiguration() {
    		return DEFAULT_CONFIGURATION;
    	}
    	
    	public static final Configuration DEFAULT_CONFIGURATION = new InheritConfiguration();
    	
    }
}
