package com.sddec.Controller;

import com.sddec.Dto.ResidentDTO;
import com.sddec.Model.Resident;
import com.sddec.Service.ResidentService;
import com.sddec.error.DuplicateResidentException;
import com.sddec.error.ResidentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Trevor on 4/10/2018.
 */
@RestController
public class ResidentController  {
    @Autowired
    ResidentService residentService;

    public ResidentController() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/residents/{res_id}", produces = "application/json")
    public ResponseEntity getResidentById(@PathVariable("res_id") int res_id) {
        Resident resident = residentService.getResidentById(res_id);

        if(resident == null) {
            throw new ResidentNotFoundException("No resident found with id: " + res_id, "/residents/");
        } else {
            return ResponseEntity.ok(resident);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/residents/new_resident/", produces = "application/json")
    public ResponseEntity addResident(@RequestBody ResidentDTO res) {
        Resident resPOJO = new Resident(res);

        if(residentService.getResidentById(resPOJO.getResidentId()) != null) {
            throw new DuplicateResidentException("Resident with id: " + resPOJO.getResidentId() + " already exists",
                    "/residents/new_resident/");

        } else {
            residentService.addResident(resPOJO);
            return ResponseEntity.ok(resPOJO);
        }
    }

}
