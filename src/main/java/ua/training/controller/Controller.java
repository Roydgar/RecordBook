package ua.training.controller;

import ua.training.model.Model;
import ua.training.person.Address;
import ua.training.person.Person;
import ua.training.view.View;

import static ua.training.MessagesConstants.*;
import static ua.training.RegexConstants.*;

import java.util.ResourceBundle;
import java.util.Scanner;
/**
 * Controller class.
 * <p>Represents MVC controller.
 * @author Roydgar
 * @version 1.0
 */
public class Controller {
    private Scanner inputScanner = new Scanner(System.in);
    private View view;
    private Model model;
    private ResourceBundle regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME);

    /**
     * Gets user information from the console
     * @param model Model instance
     * @param view View instance
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Gets user information, creates Person object and adds it to a model.
     */
    public void processUser() {
        view.printDatabase(model);
        Person person = new Person();
        Address address = new Address();
        person.setName(getUserInput(regexBundle.getString(NAME_REGEX), INPUT_NAME));
        person.setPatronymicName(getUserInput(regexBundle.getString(NAME_REGEX), INPUT_PATRONYMIC));
        person.setSurname(getUserInput(regexBundle.getString(SURNAME_REGEX), INPUT_SURNAME));
        person.setNickname(getUserInput(regexBundle.getString(NICKNAME_REGEX), INPUT_NICKNAME));
        person.setGroup(Integer.valueOf(getUserInput(regexBundle.getString(GROUP_REGEX), INPUT_GROUP)));
        person.setMobilePhone(getUserInput(regexBundle.getString(MOBILE_NUMBER_REGEX), INPUT_MOBILE_NUMBER));
        person.setComment(getUserInput(regexBundle.getString(COMMENT_REGEX), INPUT_COMMENT));
        person.setSkype(getUserInput(regexBundle.getString(SKYPE_REGEX), INPUT_SKYPE));
        person.setEmail(getUserInput(regexBundle.getString(EMAIL_REGEX), INPUT_EMAIL));
        address.setIndex(getUserInput(regexBundle.getString(POSTINDEX_REGEX), INPUT_POSTINDEX));
        address.setCity(getUserInput(regexBundle.getString(CITY_REGEX), INPUT_CITY));
        address.setStreet(getUserInput(regexBundle.getString(STREET_REGEX), INPUT_STREET));
        address.setHouseNumber(getUserInput(regexBundle.getString(HOUSE_REGEX), INPUT_HOUSE));
        address.setFlatNumber(getUserInput(regexBundle.getString(FLAT_REGEX), INPUT_FLAT));
        address.setShortedAddress();
        person.setAddress(address);
        person.setShortedName();
        model.addNewPerson(person);
        view.printThanksMessage();
    }

    /**
     * Gets user information from the console.
     * @param regex A regex String to check user input validity.
     * @param messagePropertyKey String key to get a message to user from a property file.
     * @return String containing valid user input.
     */
    public String getUserInput(String regex, String messagePropertyKey) {
        String input;
        view.printInputOffering(messagePropertyKey);
        while (!(inputScanner.hasNext() && (input = inputScanner.nextLine().trim()).matches(regex))) {
            view.printWrongInputMessage();
        }
        return input;
    }
}
