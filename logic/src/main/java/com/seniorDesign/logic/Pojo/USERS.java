package com.seniorDesign.logic.Pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "user"
)
public class USERS {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "user_id"
    )
    private int user_id;

    @Column(
            name = "resident_id"
    )
    private int resident_id;

    @Column(
            name = "user_name"
    )
    private String username;

    @Column(
            name = "pass_word"
    )
    private String password;

    @Column(
            name = "last_name"
    )
    private String lastname;

    @Column(
            name = "first_name"
    )
    private String firstname;

    public USERS() {
    }

    public USERS(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getResident_id() {
        return resident_id;
    }

    public void setResident_id(int resident_id) {
        this.resident_id = resident_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String toString() {
        return "User [id=" + this.user_id + ", username=" + this.username + ", password=" + this.password + ", firstName=" + this.firstname + ", lastName=" + this.lastname + "]";
    }
}

