package ua.training.person;

import java.io.Serializable;
import java.time.LocalDateTime;

import static ua.training.MessagesConstants.*;

/**
 * Person class
 * <p>Represents one Per.son.
 * @author Roydgar.
 * @version 1.0.
 */
public class Person implements Serializable{

    private static final long serialVersionUID = 2233005918921681227L;

    private String name;
    private String patronymicName;
    private String surname;
    private String shortedName;
    private String nickname;
    private String comment;
    private Group  group;
    private String mobileNumber;
    private String email;
    private String skype;
    private String createdDate;
    private String editedDate;
    private Address address;

    public Person() {
        String date = LocalDateTime.now().toString();
        createdDate = date;
        editedDate  = date;
    }

    public String getName() {
        return name;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public String getSurname() {
        return surname;
    }

    public String getShortedName() {
        return shortedName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getComment() {
        return comment;
    }

    public Group getGroup() {
        return group;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getEditedDate() {
        return editedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
        setEditedDate();
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
        setEditedDate();
    }

    public void setSurname(String surname) {
        this.surname = surname;
        setEditedDate();
    }

    public void setShortedName() {
        if (name != null && patronymicName != null&& surname != null) {
            this.shortedName = surname + SPACE_SIGN + name.charAt(0) + DOT_SIGN + surname.charAt(0);
            setEditedDate();
        }
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        setEditedDate();
    }

    public void setComment(String comment) {
        this.comment = comment;
        setEditedDate();
    }

    public void setGroup(int groupCode) {
        Group[] values = Group.values();
        this.group = values[groupCode];
        setEditedDate();
    }


    public void setMobilePhone(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        setEditedDate();
    }

    public void setEmail(String email) {
        this.email = email;
        setEditedDate();
    }

    public void setSkype(String skype) {
        this.skype = skype;
        setEditedDate();
    }

    public void setEditedDate() {
        this.editedDate = LocalDateTime.now().toString();
    }

    @Override
    public String toString() { return shortedName; }
}
