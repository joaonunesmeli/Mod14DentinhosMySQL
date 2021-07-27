package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.controller;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.DoctorDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.DoctorForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public IdDto create(@Valid @RequestBody DoctorForm form) {
        return this.service.create(form);
    }

    @GetMapping("/{id}")
    public DoctorDto get(@PathVariable long id) {
        return this.service.getById(id);
    }

    @GetMapping
    public List<DoctorDto> getAll() {
        return this.service.getAll();
    }

    @PutMapping("/{id}")
    public IdDto update(@PathVariable long id, @Valid @RequestBody DoctorForm form) {
        return this.service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public IdDto remove(@PathVariable long id) {
        return this.service.remove(id);
    }

}
