package transportCompany.dao;

import transportCompany.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDao {
    @Autowired
    private VehicleRepository repo;

    @Autowired
    private CompanyRepository companyRepo;

    public void add(Vehicle vehicle) {
        var existingCompany = this.companyRepo.findById(vehicle.getCompany().getId()).get();
        vehicle.setCompany(existingCompany);
        this.repo.save(vehicle);
    }

    public void update(Vehicle vehicle) {
        this.repo.save(vehicle);
    }

    public void delete(Vehicle vehicle) {
        this.repo.delete(vehicle);
    }

    public List<Vehicle> all() {
        return this.repo.findAll();
    }

    public Vehicle find(long id) {
        return this.repo.findById(id).get();
    }
}
