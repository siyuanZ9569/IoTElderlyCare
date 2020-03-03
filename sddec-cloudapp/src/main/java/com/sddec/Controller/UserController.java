package com.sddec.Controller;

import com.sddec.Dto.UserDTO;
import com.sddec.Model.Resident;
import com.sddec.Model.User;
import com.sddec.Service.ResidentService;
import com.sddec.Service.UserService;
import com.sddec.error.DuplicateUserException;
import com.sddec.error.ResidentNotFoundException;
import com.sddec.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trev on 3/31/18.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResidentService residentService;

    public UserController() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}", produces = "application/json")
    public ResponseEntity getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);

        if(user == null) {
            throw new UserNotFoundException("A User with that ID is not present", "/users/");

        } else {
            return ResponseEntity.ok(user);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value="/users/new_user/", produces = "application/json")
    public ResponseEntity addNewUser(@RequestBody UserDTO newUser) {

        User userPOJO = userService.checkUsername(newUser);

        if(userPOJO == null) {
            throw new DuplicateUserException("User will this id already exists", "/users/new_users/");

        } else {
            userService.addUser(userPOJO);
            return ResponseEntity.ok(newUser);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/users/add_resident/{res_id}/{user_id}",produces = "application/json")
    public ResponseEntity addResidentToUser(@PathVariable("res_id") int res_id, @PathVariable("user_id") int user_id) {

        Resident res = residentService.getResidentById(res_id);
        User user = userService.getUserById(user_id);

        if(res == null) {
            throw new ResidentNotFoundException("No Resident with corresponding id", "/users/add_resident/");

        } else if(user == null) {
            throw new UserNotFoundException("No User with corresponding id found", "/users/add_resident");

        } else {
            userService.addResident(user, res.getResidentId());
            return ResponseEntity.ok(user);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value="/users/get_resident/{user_id}", produces = "application/json")
    public ResponseEntity getResidentByUserId(@PathVariable("user_id") int user_id) {
        User user = userService.getUserById(user_id);
        Resident res;

        if(user == null) {
            throw new UserNotFoundException("The user id doesn't correspond to an account", "/users/get_resident/");

        } else {
            res = residentService.getResidentById(user.getResidentId());

            if(res == null) {
                throw new ResidentNotFoundException("Resident id does not correspond to a resident",
                        "/users/get_resident/");

            } else {
                return ResponseEntity.ok(res);
            }
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/login/", produces = "application/json")
    public ResponseEntity userLogin(@RequestBody UserDTO loginUser) {
        User user = userService.userLogin(loginUser);

        if(user == null) {
            throw new UserNotFoundException("User not found", "/users/login");

        } else {
            return ResponseEntity.ok(user);

        }
    }
}
