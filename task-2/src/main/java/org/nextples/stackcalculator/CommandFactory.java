package org.nextples.stackcalculator;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CommandFactory {
    private Properties properties;
    private final String configPath = "/config.properties";

    public CommandFactory() {
        properties = new Properties();
        this.loadCommands();
    }

    public Command createCommand(String name) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String fullName = properties.getProperty(name);
        return (Command) Class.forName(fullName).getDeclaredConstructors()[0].newInstance();
    }

    private void loadCommands() {
        InputStream input;
        input = CommandFactory.class.getResourceAsStream(configPath);
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Configuration file can not be read");
        }
    }
}
