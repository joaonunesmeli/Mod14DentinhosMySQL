package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.handler;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.ValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ValidationDto dto = processFieldErrors(fieldErrors);
        return ResponseEntity.badRequest().body(dto);
    }

    public ValidationDto processFieldErrors(List<FieldError> fieldErrors) {
        Map<String, String> exceptions = new HashMap<>();
        for (FieldError fieldError: fieldErrors) {
            exceptions.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ValidationDto(exceptions);
    }

}
