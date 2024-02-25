package org.nextples;

import org.nextples.stackcalculator.Command;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Properties;

public class CommandFactory {
    private Properties factory;
    private String configPath = "/config.properties";

    public CommandFactory() {
        factory = new Properties();
        try {
            factory.load(new FileReader(configPath));
        } catch (IOException e) {
            throw new RuntimeException("Configuration file con not be read");
        }
    }


}
