package com.in28minutes.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    private Log logger = LogFactory.getLog(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        logger.error(String.format("Request: %s - threw an exception: %s", request.getRequestURI(), ex));
        return "error";
    }
}
