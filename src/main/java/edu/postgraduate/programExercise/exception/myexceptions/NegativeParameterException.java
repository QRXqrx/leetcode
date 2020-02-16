package edu.postgraduate.programExercise.exception.myexceptions;

public class NegativeParameterException extends RuntimeException{
    static final long serialVersionUID = -7034897745766939L;

    public NegativeParameterException() {
    }

    public NegativeParameterException(String message) {
        super(message);
    }
}
