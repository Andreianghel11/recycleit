package com.project.recycleit.exceptionHandler;

public class UserNotLoggedInException extends RuntimeException{
    public UserNotLoggedInException(String message) {
        super(message);
    }
}
