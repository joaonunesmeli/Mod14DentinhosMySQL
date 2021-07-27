package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.controller;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.PatientDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.PatientForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public IdDto create(@Valid @RequestBody PatientForm form) {
        return this.service.create(form);
    }

    @GetMapping("/{id}")
    public PatientDto get(@PathVariable long id) {
        return this.service.getById(id);
    }

    @GetMapping
    public List<PatientDto> getAll() {
        return this.service.getAll();
    }

    @PutMapping("/{id}")
    public IdDto update(@PathVariable long id, @Valid @RequestBody PatientForm form) {
        return this.service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public IdDto remove(@PathVariable long id) {
        return this.service.remove(id);
    }

}
