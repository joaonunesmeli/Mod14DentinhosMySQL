package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity;

public interface IEntity<E> {
    void setId(Long id);
    Long getId();
    void set(E e);
}
