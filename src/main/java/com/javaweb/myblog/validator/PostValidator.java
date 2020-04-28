package com.javaweb.myblog.validator;

import com.javaweb.myblog.model.PostModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return PostModel.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        PostModel postModel = (PostModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortDescription", "field.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "field.empty");
    }
}

