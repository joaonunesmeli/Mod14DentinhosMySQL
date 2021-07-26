package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(long id) {
        super("Paciente " + id + " não encontrado");
    }
}
