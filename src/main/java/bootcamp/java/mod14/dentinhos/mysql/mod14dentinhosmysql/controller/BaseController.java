package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.controller;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.IEntity;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service.BaseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

abstract class BaseController<E extends IEntity, F, D> {
    private BaseService<E, F, D> service;

    public BaseController(BaseService<E, F, D> service) {
        this.service = service;
    }

    @PostMapping
    public IdDto create(@Valid @RequestBody F form) {
        return this.service.create(form);
    }

    @GetMapping("/{id}")
    public D get(@PathVariable long id) {
        return this.service.getById(id);
    }

    @GetMapping
    public List<D> getAll() {
        return this.service.getAll();
    }

    @PutMapping("/{id}")
    public IdDto update(@PathVariable long id, @Valid @RequestBody F form) {
        return this.service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public IdDto remove(@PathVariable long id) {
        return this.service.remove(id);
    }
}
