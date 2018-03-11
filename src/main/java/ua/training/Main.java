package ua.training;

import ua.training.controller.Controller;
import ua.training.model.Model;
import ua.training.view.View;

/**
 * A main class.
 * <p>Represents a start point of the program.
 * @author Roydgar.
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
