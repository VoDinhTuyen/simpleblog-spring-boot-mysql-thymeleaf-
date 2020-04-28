package com.javaweb.myblog.validator;

import com.javaweb.myblog.model.UserModel;
import com.javaweb.myblog.service.impl.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserModel userModel = (UserModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.empty");
        if(userService.findByUserName(userModel.getUserName()) != null) {
            errors.rejectValue("userName", "Username.already");
        }
        if(userModel.getPassword().length() < 6 || userModel.getPassword().length() > 12) {
            errors.rejectValue("password", "Size.password");
        }
        if(!this.emailValidator.isValid(userModel.getEmail())) {
            errors.rejectValue("email", "Email.pattern");
        }
        else if(userModel.getId() == null) {
            UserModel userModel1 = userService.findByEmail(userModel.getEmail());
            if(userModel1 != null) {
                errors.rejectValue("email", "Email.already");
            }
        }
    }
}
