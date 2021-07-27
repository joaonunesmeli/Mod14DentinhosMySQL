package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.IEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class BaseService<E extends IEntity, F, D> {
    private JpaRepository<E, Long> repository;
    private Function<F, E> toEntity;
    private Function<E, D> toDto;

    public BaseService(JpaRepository<E, Long> repository, Function<F, E> toEntity, Function<E, D> toDto) {
        this.repository = repository;
        this.toEntity = toEntity;
        this.toDto = toDto;
    }

    public IdDto create(F form) {
        E a = this.toEntity.apply(form);
        return new IdDto(this.repository.save(a).getId());
    }

    public D getById(Long id) {
        Optional<E> e = this.repository.findById(id);
        if (e.isEmpty()) {
            return null;
        }
        return toDto.apply(e.get());
    }

    public List<D> getAll() {
        return this.repository.findAll().stream().map(e -> toDto.apply(e)).collect(Collectors.toList());
    }

    public IdDto update(Long id, F form) {
        Optional<E> opt = this.repository.findById(id);
        if (opt.isEmpty()) {
            return this.create(form);
        }

        E received = this.toEntity.apply(form);
        E saved = opt.get();

        saved.set(received);
        this.repository.save(saved);
        return new IdDto(id);
    }

    public IdDto remove(Long id) {
        this.repository.deleteById(id);
        return new IdDto(id);
    }
}
