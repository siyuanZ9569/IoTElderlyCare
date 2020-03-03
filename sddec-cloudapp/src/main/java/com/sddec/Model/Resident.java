package com.sddec.Model;

import com.sddec.Dto.ResidentDTO;
import com.sddec.Util.IdGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;

/**
 * Created by trev on 3/31/18.
 */
@Entity
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int residentId;

    private String firstName;

    private String lastName;

    public Resident(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Resident() {}

    public Resident(ResidentDTO residentDTO) {
        this.residentId = residentDTO.getResidentId();
        this.firstName = residentDTO.getFirstName();
        this.lastName = residentDTO.getLastName();
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

    public void setResidentId(int id) {
        residentId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Resident: %s, %s", firstName, lastName);
    }
}
