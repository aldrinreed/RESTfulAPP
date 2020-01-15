package com.firstSpringProject.app.ws.services;

import com.firstSpringProject.app.ws.combine.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/28/2019
 * Time:   6:15 PM
 */
public interface userService extends UserDetailsService {
    UserDTO createUser(UserDTO user);
}
