package com.sddec.Service;

import com.sddec.Dto.UserDTO;
import com.sddec.Model.User;
import com.sddec.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by trev on 3/31/18.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User getUserById(int id) {
        Optional<User> toFind = userRepo.findById(id);
        if(toFind.isPresent()) {
            return toFind.get();

        } else {
            return null;
        }
    }

    public void addUser(User toAdd) {
        userRepo.save(toAdd);
    }

    public User addResident(User user, int residentId) {
        user.setResidentId(residentId);
        userRepo.save(user);
        return user;
    }

    public User checkUsername(UserDTO newUser) {
        ArrayList<User> users = userRepo.findUserByUserName(newUser.getUserName());

        if(users.isEmpty()) {
            return new User(newUser);
        } else {
            return null;
        }

    }

    public User userLogin(UserDTO user) {
        ArrayList<User> users = userRepo.findUserByUserNameAndPassWord(user.getUserName(),user.getPassword());

        if(users.isEmpty()) {
            return null;

        } else {
            return users.get(0);
        }

    }

}
