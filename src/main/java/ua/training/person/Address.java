package ua.training.person;

import java.io.Serializable;

import static ua.training.MessagesConstants.*;

/**
 * Address class.
 * <p>Represents user address.
 * @author Roydgar.
 * @version 1.0.
 */

public class Address implements Serializable {

    private static final long serialVersionUID = -7910947512845760711L;

    private String index;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;

    private String shortedAddress;

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setShortedAddress() {
        this.shortedAddress = index + COMMA_SIGN + SPACE_SIGN + city + COMMA_SIGN + SPACE_SIGN + street + COMMA_SIGN +
                SPACE_SIGN + street + COMMA_SIGN + SPACE_SIGN + houseNumber  + COMMA_SIGN + SPACE_SIGN + flatNumber;
    }

    @Override
    public String toString() {
        return shortedAddress;
    }
}
