package org.nextples.stackcalculator;

public class NameProcessor {
    public static String getCommandCreatorName(String commandName) {
        String fullName = commandName.toLowerCase();
        fullName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1);
        fullName = "org.nextples.stackcalculator." + fullName + "Creator";
        return fullName;
    }
}
