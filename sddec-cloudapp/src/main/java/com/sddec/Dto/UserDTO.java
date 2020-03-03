package com.sddec.Dto;

/**
 * Created by Trevor on 4/5/2018.
 */
public class UserDTO {

    private int residentId;

    private String firstName;

    private String lastName;

    private String password;

    private int userId;

    private String userName;

    public UserDTO(int residentId, String firstName, String lastName, String password, int userId, String userName) {
        this.residentId = residentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userId = userId;
        this.userName = userName;
    }

    public UserDTO() {

    }


    public int getResidentId() {
        return  residentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }
}
