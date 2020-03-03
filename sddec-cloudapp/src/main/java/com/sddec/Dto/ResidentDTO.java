package com.sddec.Dto;

/**
 * Created by Trevor on 4/10/2018.
 */
public class ResidentDTO {
    private int residentId;

    private String firstName;

    private String lastName;

    public ResidentDTO(int residentId, String firstName, String lastName) {
        this.residentId = residentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ResidentDTO() {

    }

    public int getResidentId() {
        return residentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
