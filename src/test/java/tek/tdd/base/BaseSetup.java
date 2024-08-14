package tek.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Read Config File
 * Open Browser
 * Quit Browser
 * Encapsulate instance of WebDriver
 */
public abstract class BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);

    private static WebDriver driver;
    private Properties properties;

    public BaseSetup() {
        //Reading Config Files and Loading to properties
        String configFilePath = System.getProperty("user.dir")
                + "/src/test/resources/configs/dev-config.properties";
        try {
            LOGGER.debug("Reading Config file from path {}", configFilePath);
            InputStream inputStream = new FileInputStream(new File(configFilePath));
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException ioException) {
            LOGGER.error("Config file error with message {}", ioException.getMessage());
            throw new RuntimeException("Config file error with message" + ioException.getMessage());
        }
    }


}
