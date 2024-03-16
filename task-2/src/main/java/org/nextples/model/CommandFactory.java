package org.nextples.model;

import org.nextples.error.IllegalCommandNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommandFactory {
    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class);

    private Properties properties;
    private final String configPath;

    public CommandFactory(String configPath) {
        properties = new Properties();
        this.configPath = configPath;
        this.loadCommands();
        logger.info("CommandFactory has been created successfully");
    }

    public Command createCommand(String name) throws IllegalCommandNameException {
        String fullName = properties.getProperty(name);
        try {
            return (Command) Class.forName(fullName).getDeclaredConstructors()[0].newInstance();
        } catch (ReflectiveOperationException e) {
            logger.error("Invalid command name: " + name);
            throw new IllegalCommandNameException("Invalid command name: " + name);
        }

    }

    private void loadCommands() {
        InputStream input;
        input = CommandFactory.class.getResourceAsStream(configPath);
        try {
            properties.load(input);
        } catch (IOException e) {
            logger.error("Configuration {} file can not be read", configPath);
            throw new RuntimeException("Configuration file can not be read");
        }
    }
}
