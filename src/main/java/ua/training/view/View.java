package ua.training.view;

import ua.training.model.Model;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.training.MessagesConstants.*;

/**
 * View class
 * <p>Represents MVC view class. Works with a console
 * @author Roydgar
 * @version 1.0
 */
public class View {
    private static ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME,
            //new Locale("ru")
            new Locale("en")
    );

    /**
     * Prints given message to the console
     * @param message String to print
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints offering message to the console
     * @param propertyKey String key to get a message to user from a property file
     */
    public void printInputOffering(String propertyKey) { printMessage(bundle.getString(propertyKey)); }

    /**
     * Prints wrong input message to the console
     */
    public void printWrongInputMessage() { printMessage(bundle.getString(WRONG_INPUT)); }

    /**
     * Prints all the model data to a console
     * @param model Model instance to get data from
     */
    public void printDatabase(Model model) {
        printMessage(bundle.getString(OUTPUT_DATABASE) + NEWLINE_SIGN + model.getData());
    }
    /**
     * Prints message to the console
     */
    public void printThanksMessage() { printMessage(bundle.getString(OUTPUT_THANKS)); }
}
