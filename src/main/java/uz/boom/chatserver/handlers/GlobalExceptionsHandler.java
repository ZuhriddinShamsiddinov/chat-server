package uz.boom.chatserver.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.boom.chatserver.exceptions.BadRequestException;
import uz.boom.chatserver.response.ApiErrorResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:59 PM 10/9/22 on Sunday in October
 */
@RestControllerAdvice
public class GlobalExceptionsHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handle400(BadRequestException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(e.getLocalizedMessage())
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.BAD_REQUEST);
    }

}
