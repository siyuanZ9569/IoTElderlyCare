package com.sddec.Service;

import com.sddec.Model.Resident;
import com.sddec.Model.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Trevor on 4/10/2018.
 */
@Component
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    public Resident getResidentById(int id) {
        Optional<Resident> resToFind = residentRepository.findById(id);

        if(resToFind.isPresent()) {
            return resToFind.get();

        } else {
            return null;
        }
    }

    public void addResident(Resident resident) {
        residentRepository.save(resident);

    }


}
