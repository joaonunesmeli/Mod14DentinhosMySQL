package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(long id) {
        super("Consulta " + id + " não encontrada");
    }
}
