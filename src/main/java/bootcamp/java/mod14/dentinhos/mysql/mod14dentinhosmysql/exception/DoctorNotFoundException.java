package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(long id) {
        super("Médico/dentista " + id + " não encontrado");
    }
}
