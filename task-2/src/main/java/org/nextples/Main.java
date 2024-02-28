package org.nextples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.nextples.stackcalculator.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner;
        if (args.length == 0) {
            logger.info("The program is running in console reading mode");
            System.out.println("The program is running in console reading mode\nTo end the program, enter \"STOP\"");
            scanner = new Scanner(System.in);
        }
        else {
            try {
                logger.info("The program is running in read-from-file mode");
                scanner = new Scanner(new FileInputStream(args[0]));
            } catch (FileNotFoundException e) {
                logger.error(e.getMessage());
                throw new RuntimeException();
            }
        }

        CommandFactory factory;
        factory = new CommandFactory("/config.properties");

        StackCalculator calculator = new StackCalculator(factory);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (Objects.equals(line, "STOP")) {
                logger.info("Program has been stopped successfully by \"STOP\"");
                System.out.println("Program has been stopped successfully by \"STOP\"");
                return;
            }
            if (line.charAt(0) == '#') {
                continue;
            }

            try {
                calculator.executeCommand(line);
            }
            catch (IllegalArgumentException | ArithmeticException | IllegalAccessException | IllegalCommandNameException e) {
                if (args.length == 0) {
                    System.err.println(e.getMessage());
                }
                else {
                    logger.info("Program was terminated because of RuntimeException");
                    throw new RuntimeException();
                }
            }
        }
        logger.info("Program has been stopped successfully at the end of the file");
    }
}