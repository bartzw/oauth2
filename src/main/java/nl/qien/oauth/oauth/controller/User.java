package nl.qien.oauth.oauth.controller;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String password;
    final int level = 2;
    private static List<User> users = new ArrayList<>();

    public User(){}
    public User(Long id, String firstname, String lastname, String emailAdress, String password) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.emailAdress = emailAdress;
        this.password = password;
    }

    public static List getUserList() {
        return users;
    }

    public void setUserList(Long id, String firstname, String lastname, String email, String password) {
        users.add(new User(id, firstname, lastname, email, password));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
