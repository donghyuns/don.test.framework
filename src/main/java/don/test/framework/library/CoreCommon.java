package don.test.framework.library;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;

public class CoreCommon {

    public static PropertiesConfiguration config = null;
    public static boolean isRunningInGrid = false;

    public static void initConfigurations(String configfile) throws Exception {
        // Initialize configuration
        Configurations configs = new Configurations();
        // Read data from this file
        File propertiesFile = new File(configfile);
        //FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder(propertiesFile);
        PropertiesConfiguration conf = configs.properties(propertiesFile);

        config = conf;
    }

}
