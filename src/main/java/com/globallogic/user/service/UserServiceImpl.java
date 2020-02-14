package com.globallogic.user.service;

import com.globallogic.user.exception.ValidDataException;
import com.globallogic.user.model.UserContact;
import com.globallogic.user.repository.UserRepository;
import com.globallogic.user.util.RandomUtil;
import com.globallogic.user.util.ValidationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by cristianfgr on 13-02-20.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserContact> setUser(UserContact userContact) throws ValidDataException  {
        setInformationValidation(userContact);
        try {
            userRepository.save(userContact);
        }catch (Exception sqlEx) {
            LOGGER.error("Correo como UNIQUE, por lo que no se puede repetir");
            throw new ValidDataException("El correo ya registrado.");
        }
        return userRepository.findById(userContact.getId());
    }

    private void setInformationValidation(UserContact userContact) throws ValidDataException {
        userContact.setId(RandomUtil.unique());
        userContact.setToken(RandomUtil.doGenerateToken(userContact));
        ValidationUtil.validateEmail(userContact);
        ValidationUtil.validatePassword(userContact);
    }


}
