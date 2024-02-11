package com.example.exceptions.handlers;

import com.example.exceptions.dto.MyErrorResponse;
import com.example.exceptions.services.EnumInfoProvider;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice

public class GlobalExceptionHandler {

    private final EnumInfoProvider enumInfoProvider;

    private final String enumErrorMessage = "The value [%s] is not a valid value for [%s]. The valid values are [%s].";

    public GlobalExceptionHandler(EnumInfoProvider enumInfoProvider) {
        this.enumInfoProvider = enumInfoProvider;
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody MyErrorResponse handleException(MethodArgumentTypeMismatchException ex) {

        return new MyErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                String.format(enumErrorMessage, ex.getValue(), enumInfoProvider.getFriendlyName(ex.getRequiredType()), enumInfoProvider.getValidValues(ex.getRequiredType()))
        );
    }

}


