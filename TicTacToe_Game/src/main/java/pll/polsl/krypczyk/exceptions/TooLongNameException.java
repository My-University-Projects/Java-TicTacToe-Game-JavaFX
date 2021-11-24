package pll.polsl.krypczyk.exceptions;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representing my own Exception
 */
public class TooLongNameException extends Exception {

    /**
     * TooLongNameException constructor
     */
    public TooLongNameException() {
    }

    /**
     * TooLongNameException one argument constructor
     *
     * @param message created for the user after throwing an exception
     */
    public TooLongNameException(String message) {
        //super(message);
        System.out.println(message);
    }
}
