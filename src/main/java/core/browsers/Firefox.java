package core.browsers;

import io.github.sskorol.config.XmlConfig;
import io.github.sskorol.core.Browser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements Browser {
    @Override
    public Name name() {
        return Name.Firefox;
    }

    @Override
    public Capabilities configuration(XmlConfig config) {
        final FirefoxOptions options = new FirefoxOptions();
        options.setCapability("enableVNC", true);
        options.setCapability("name", config.getTestName());
        options.setCapability("screenResolution", "1280x1024x24");
        return merge(config, options);
    }

    @Override
    public boolean isRemote() {
        return true;
    }
}
