package com.example.Springbootpractice.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //Exception Handling done
    @ExceptionHandler(DepartmentNotFoundException.class)
    private ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException departmentNotFoundException, WebRequest request)
    {
        ErrorMessage errorMessages = new ErrorMessage(departmentNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessages);
    }
}

/*
How exception handling works is like this, you create a custom exception which extends the exception class alright
and you throw that exception, without any exception handler if we throw the error would come, but it would come as part of the response
along with other things too, if we just want the error message to show,

otherwise we create an responseEntityExceptionHandler, what it does is that, it takes the exceptions and handles them properly
for this we add the annotation of controllerAdvice and a response status

I need to read a lil more about them

then we make the function, which handles the exception, and we send our exception object, create an object which we wanna send, and then set status
and using response entity send what we wanted to send after annotating it with the exceptionHandler(exceptionClassname)

might need some practice to be good with this
 */