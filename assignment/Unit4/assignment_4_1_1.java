import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.Locale;
import java.io.IOException;

public class assignment_4_1_1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Logger logger = Logger.getLogger(assignment_4_1_1.class.getName());

        // Set the logger level to ALL to capture all levels of log messages
        logger.setLevel(Level.ALL);

        // Create a console handler and set its level to ALL
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        try {
            // Create a file handler to save logs to "logfile.log"
            FileHandler fileHandler = new FileHandler("logfile.log", true); // Append mode
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter()); // Format output as plain text
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Failed to create file handler: " + e.getMessage());
        }

        // Log messages of various levels
        logger.severe("This is a SEVERE level log message.");
        logger.warning("This is a WARNING level log message.");
        logger.info("This is an INFO level log message.");
        logger.config("This is a CONFIG level log message.");
        logger.fine("This is a FINE level log message.");
        logger.finer("This is a FINER level log message.");
        logger.finest("This is a FINEST level log message.");
    }
}
