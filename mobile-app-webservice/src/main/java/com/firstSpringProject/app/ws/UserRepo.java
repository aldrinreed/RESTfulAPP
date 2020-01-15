package com.firstSpringProject.app.ws;

import com.firstSpringProject.app.ws.InOut.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/28/2019
 * Time:   6:29 PM
 */

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
