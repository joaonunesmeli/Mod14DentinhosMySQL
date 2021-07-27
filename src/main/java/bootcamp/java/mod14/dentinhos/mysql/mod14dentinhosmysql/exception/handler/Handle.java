package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.handler;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.ExceptionDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.ValidationDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.AppointmentNotFoundException;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.DoctorNotFoundException;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.PatientNotFoundException;
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
public class Handle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
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

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<?> appointmentNotFoundException(AppointmentNotFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<?> doctorNotFoundException(DoctorNotFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<?> patientNotFoundException(PatientNotFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e.getMessage()));
    }

}
