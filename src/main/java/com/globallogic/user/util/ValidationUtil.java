package com.globallogic.user.util;

import com.globallogic.user.exception.ValidDataException;
import com.globallogic.user.model.UserContact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cristianfgr on 13-02-20.
 */
public final class ValidationUtil {

    private static final Logger LOGGER = LogManager.getLogger(ValidationUtil.class);

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("[A-Z]{1}[a-z]+\\d{2}");

    public static void validateEmail(UserContact userContact) throws ValidDataException {
        LOGGER.debug("Metodo que valida el email ", userContact.getEmail());
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        validator.validateProperty(userContact, "password")
                .stream()
                .forEach(violation -> LOGGER.error(violation.getMessage()));
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(userContact.getEmail());
        if(!matcher.find()) {
            LOGGER.error("Email must be a well-formed email address");
            throw new ValidDataException("Email must be a well-formed email address");
        }

    }

    public static void validatePassword(UserContact userContact) throws ValidDataException {
        LOGGER.debug("Metodo que valida formato requerido para el password ", userContact.getPassword());
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        validator.validateProperty(userContact, "password")
                .stream()
                .forEach(violation -> LOGGER.error(violation.getMessage()));
        Matcher matcher = VALID_PASSWORD_REGEX .matcher(userContact.getPassword());
        if(!matcher.find()) {
            LOGGER.error("Password not match with required");
            throw new ValidDataException("Password not match with required");
        }
    }

}
