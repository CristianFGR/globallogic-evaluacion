package com.globallogic.user.service;

import com.globallogic.user.exception.ValidDataException;
import com.globallogic.user.model.UserContact;

import java.util.Optional;

/**
 * Created by cristianfgr on 13-02-20.
 */
public interface UserService {

    Optional<UserContact> setUser(UserContact userContact) throws ValidDataException;

}
