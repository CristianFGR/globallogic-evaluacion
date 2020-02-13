package com.globallogic.user.service;

import com.globallogic.user.exception.ValidDataException;
import com.globallogic.user.model.UserContact;
import com.globallogic.user.repository.UserRepository;
import com.globallogic.user.util.RandomUtil;
import com.globallogic.user.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

/**
 * Created by cristianfgr on 13-02-20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserContact> setUser(UserContact userContact) throws ValidDataException  {
        userContact.setId(RandomUtil.unique());
        dataValidation(userContact);
        try {
            userRepository.save(userContact);
        }catch (Exception sqlEx) {
            throw new ValidDataException("El correo ya registrado.");
        }
        return userRepository.findById(userContact.getId());
    }

    private void dataValidation(UserContact userContact) throws ValidDataException {
        ValidationUtil.validateEmail(userContact);
        ValidationUtil.validatePassword(userContact);
    }

}
