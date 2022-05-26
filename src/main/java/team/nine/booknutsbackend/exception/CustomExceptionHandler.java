package team.nine.booknutsbackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;


@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> CommonExceptionHandler(Exception e) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("error", e.getClass().getSimpleName());
        map.put("msg", e.getMessage());
        return new ResponseEntity<>(map, HttpStatusMap.getCode(e));
    }

}
