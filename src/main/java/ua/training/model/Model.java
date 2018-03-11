package ua.training.model;


import ua.training.person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class.
 * <p>Represents MVC model class. Contains all the data.
 * @author Roydgar.
 * @version 1.0
 */

public class Model {
    List<Person> people = new ArrayList<>();
    private static final String DEFAULT_FILE_NAME = "people.out";

    public Model() {
        people = deserialize();
    }

    public void addNewPerson(Person person) {
        people.add(person);
        serialize();
    }

    /**
     * Returns List of Person, containing all the data.
     * @return List - List of Person, containing all the data.
     */
    public List<Person> getData() { return people; }

    private void serialize(String fileName) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            stream.writeObject(people);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serialize() { serialize(DEFAULT_FILE_NAME); }

    private  List<Person> deserialize(String fileName) {
        if (!(new File(fileName).exists()))
            return new ArrayList<>();
        List<Person> people = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(
                    new FileInputStream(fileName));
            people = (List<Person>)stream.readObject();
            stream.close();
            return people;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<Person> deserialize() { return deserialize(DEFAULT_FILE_NAME); }
}
