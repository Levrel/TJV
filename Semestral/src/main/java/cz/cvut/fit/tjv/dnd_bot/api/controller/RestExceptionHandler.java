package cz.cvut.fit.tjv.dnd_bot.api.controller;

import cz.cvut.fit.tjv.dnd_bot.business.EntityStateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityStateException.class)
    protected ResponseEntity<?> IDTaken(Exception e, WebRequest wr){
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> entityDoesNotExist(Exception e, WebRequest wr){
        var m = Map.of( "timestamp", LocalDateTime.now(), "message", "not found" );
        return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
    }
}
