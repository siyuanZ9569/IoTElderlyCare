package com.sddec.Model;

import com.sddec.Dto.UserDTO;
import com.sddec.Util.IdGenerator;

import javax.persistence.*;


/**
 * Created by trev on 3/31/18.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "userId")
    private int userId;

    private String userName;

    //@Column(name = "first_name")
    private String firstName;

    //@Column(name = "lastName")
    private String lastName;

    //@Column(name = "pass_word")
    private String passWord;

    //
    //
    // @Column(name = "residentId")
    private int residentId;

    public User(String firstName, String lastName, String pass_word, int residentId, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = pass_word;
        this.residentId = residentId;
        this.userName = userName;
    }

    public User() {

    }

    public User(UserDTO newUser) {
        this.firstName = newUser.getFirstName();
        this.lastName = newUser.getLastName();
        this.passWord = newUser.getPassword();
        this.residentId = newUser.getResidentId();
        this.userName = newUser.getUserName();

    }
    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return passWord;
    }

    public int getResidentId() {
        return residentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public void setUserId(int newId) {
        userId = newId;
    }

    public void setFirstName(String newName) {
        firstName = newName;
    }

    public void setLastName(String newName) {
        lastName = newName;
    }

    @Override
    public String toString() {
        return String.format("User: %s, %s", firstName, lastName);
    }


}
