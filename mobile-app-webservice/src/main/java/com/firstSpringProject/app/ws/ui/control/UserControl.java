package com.firstSpringProject.app.ws.ui.control;

import com.firstSpringProject.app.ws.combine.dto.UserDTO;
import com.firstSpringProject.app.ws.services.userService;
import com.firstSpringProject.app.ws.ui.model.request.UserDetailsRequest;
import com.firstSpringProject.app.ws.ui.model.response.UserREST;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/28/2019
 * Time:   4:22 PM
 */

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserControl {

    @Autowired
    userService userService;

    @GetMapping
    public String getUser(){
        return  "Get user method was called";
    }

    @PostMapping
    public UserREST createUser(@RequestBody UserDetailsRequest userDetails){

        UserREST returnVal = new UserREST();
        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, returnVal);

        return returnVal;
    }

    @PutMapping
    public String updateUser(){
        return "Update user method was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return  "Delete user method was called";
    }

}
