package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;

/**
 * Created by trev on 3/31/18.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
     ArrayList<User> findUserByFirstName(String firstName);

     ArrayList<User> findUserByLastName(String lastName);

     ArrayList<User> findUserByUserName(String userName);

     ArrayList<User> findUserByUserNameAndPassWord(String userName, String password);
}
