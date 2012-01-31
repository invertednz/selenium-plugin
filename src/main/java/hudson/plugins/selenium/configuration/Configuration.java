package hudson.plugins.selenium.configuration;

import java.util.List;

import hudson.DescriptorExtensionList;
import hudson.model.Describable;
import hudson.model.Hudson;
import hudson.model.Node;

import org.kohsuke.stapler.export.ExportedBean;

@ExportedBean
public abstract class Configuration implements Describable<Configuration> {


	public ConfigurationDescriptor getDescriptor() {
        return (ConfigurationDescriptor)Hudson.getInstance().getDescriptor(getClass());
    }

    public static DescriptorExtensionList<Configuration,ConfigurationDescriptor> all() {
        return Hudson.getInstance().<Configuration,ConfigurationDescriptor>getDescriptorList(Configuration.class);
    }
	
    public static DescriptorExtensionList<Configuration,ConfigurationDescriptor> allExcept(Node current) {
        return Hudson.getInstance().<Configuration,ConfigurationDescriptor>getDescriptorList(Configuration.class);
    }
    
	public abstract List<String> getLaunchingArguments();

}