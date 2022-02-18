package transportCompany.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import transportCompany.dao.VehicleDao;
import transportCompany.models.Vehicle;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    private VehicleDao vehicleDao;

    public VehiclesController(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;

    }

    @GetMapping
    public List<Vehicle> getAll() {
        return this.vehicleDao.all();
    }

    @PostMapping
    public void create(@RequestBody Vehicle client) {
        this.vehicleDao.add(client);
    }

    @PutMapping
    public void update(@RequestBody Vehicle client) {
        this.vehicleDao.update(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Vehicle client) {
        this.vehicleDao.delete(client);
    }
}
