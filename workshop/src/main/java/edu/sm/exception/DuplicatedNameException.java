package edu.sm.exception;

public class DuplicatedNameException extends Exception{
    public DuplicatedNameException() {}
    public DuplicatedNameException(String message) {
        super(message);
    }
}
