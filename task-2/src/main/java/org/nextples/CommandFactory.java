package org.nextples;

import org.nextples.stackcalculator.Command;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class CommandFactory {
    private HashMap<String, Command> factory;
    private final String configPath = "/config.properties";

    public CommandFactory() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        factory = new HashMap<>();
        this.loadCommands();
    }

    public Command createCommand(String name) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (Command) Class.forName(name).getDeclaredConstructors()[0].newInstance();
    }

    private void loadCommands() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        InputStream input;
        input = CommandFactory.class.getResourceAsStream(configPath);
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Configuration file con not be read");
        }
        for (Object key : properties.keySet()) {
            String commandName = (String) key;
            Command command = createCommand(commandName);
            factory.put(commandName, command);
        }
    }
}
