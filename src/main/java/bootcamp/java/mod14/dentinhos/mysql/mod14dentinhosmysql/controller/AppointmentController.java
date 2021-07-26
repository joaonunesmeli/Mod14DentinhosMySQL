package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.controller;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.AppointmentDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.AppointmentForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Appointment;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping("/:doctorId/:patientId")
    public IdDto create(@PathVariable long doctorId, @PathVariable long patientId, @RequestBody AppointmentForm form) {
        return this.service.create(doctorId, patientId, form);
    }

    @GetMapping("/by_doctor_id/{id}")
    public List<AppointmentDto> getByDoctorId(@PathVariable long id) {
        return this.service.getByDoctorId(id);
    }

    @GetMapping("/by_status/{id}")
    public List<AppointmentDto> getByStatus(@PathVariable Appointment.Status status) {
        return this.service.getByStatus(status.toString());
    }
}
