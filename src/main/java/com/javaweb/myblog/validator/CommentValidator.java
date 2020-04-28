package com.javaweb.myblog.validator;

import com.javaweb.myblog.model.CommentModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CommentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CommentModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CommentModel commentModel = (CommentModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"content", "field.empty");
    }
}
