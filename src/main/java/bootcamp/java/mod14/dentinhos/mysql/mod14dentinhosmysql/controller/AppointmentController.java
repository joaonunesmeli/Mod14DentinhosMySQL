package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.controller;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.AppointmentDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.AppointmentForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Appointment;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AppointmentController {
    private AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping("/appointments")
    public IdDto create(@Valid @RequestBody AppointmentForm form) {
        return this.service.create(form.getDoctorId(), form.getPatientId(), form);
    }

    @GetMapping("/appointments_by_doctor_id/{id}")
    public List<AppointmentDto> getByDoctorId(@PathVariable long id) {
        return this.service.getByDoctorId(id);
    }

    @GetMapping("/appointments_by_status/{status}")
    public List<AppointmentDto> getByStatus(@PathVariable Appointment.Status status) {
        return this.service.getByStatus(status);
    }

}
