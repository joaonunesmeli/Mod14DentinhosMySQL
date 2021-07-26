package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto;

import java.util.Map;

public class ValidationDto {
    private Map<String, String> errors;

    public ValidationDto(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
