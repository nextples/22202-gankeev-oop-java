package org.example;

public class NameProcessor {
    public static String getCommandCreatorName(String commandName) {
        String fullName = commandName.toLowerCase();
        fullName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1);
        fullName = "org.example." + fullName + "Creator";
        return fullName;
    }
}
