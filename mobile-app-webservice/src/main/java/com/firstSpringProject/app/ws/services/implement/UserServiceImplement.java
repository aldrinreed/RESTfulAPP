package com.firstSpringProject.app.ws.services.implement;

import com.firstSpringProject.app.ws.InOut.entity.UserEntity;
import com.firstSpringProject.app.ws.UserRepo;
import com.firstSpringProject.app.ws.combine.dto.UserDTO;
import com.firstSpringProject.app.ws.combined.Utils;
import com.firstSpringProject.app.ws.services.userService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/28/2019
 * Time:   6:16 PM
 */

@Service
public class UserServiceImplement implements userService {

    @Autowired
    Utils utils;

    @Autowired
    UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO user){

        //UserEntity storedUserDetails = userRepo.findByEmail(user.getEmail());

        if(userRepo.findByEmail(user.getEmail()) != null)
            throw new RuntimeException("Record already exists");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserID = utils.generateUserID(30);

        // Setting user credentials
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserID(publicUserID);

        UserEntity storedUserDetails = userRepo.save(userEntity);

        UserDTO returnVal = new UserDTO();
        BeanUtils.copyProperties(storedUserDetails, returnVal);

        return returnVal;
    }


    // Spring framework
    // help load user details
    // in the process of user sign in
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(s);
        if(userEntity == null) throw new UsernameNotFoundException(s);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
