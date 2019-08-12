package com.danish.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String courseCodeFromHtmlForm, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if (courseCodeFromHtmlForm != null)
            result = courseCodeFromHtmlForm.startsWith(coursePrefix);
        else
            result = true;

        return result;
    }

}
