package uz.boom.chatserver.exceptions;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:44 PM 10/9/22 on Sunday in October
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
