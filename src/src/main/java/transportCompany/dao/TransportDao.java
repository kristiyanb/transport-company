package transportCompany.dao;

import transportCompany.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TransportDao {
    @Autowired
    private TransportRepository repo;

    @Autowired
    private CompanyRepository companyRepo;
    
    @Autowired
    private VehicleRepository vehicleRepo;
    
    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Transport transport) {
        var existingCompany = this.companyRepo.findById(transport.getCompany().getId()).get();
        transport.setCompany(existingCompany);
        
        var existingVehicle = this.vehicleRepo.findById(transport.getVehicle().getId()).get();
        transport.setVehicle(existingVehicle);
        
        var existingClient = this.clientRepo.findById(transport.getClient().getId()).get();
        transport.setClient(existingClient);
        
        var existingEmployee = this.employeeRepo.findById(transport.getEmployee().getId()).get();
        transport.setEmployee(existingEmployee);

        this.repo.save(transport);
    }

    public void update(Transport transport) {        
        Transport dbEntity = this.repo.findById(transport.getId()).get();
        dbEntity.setDepartureLocation(transport.getDepartureLocation());
        dbEntity.setDepartureTime(transport.getDepartureTime());
        dbEntity.setArrivalLocation(transport.getArrivalLocation());
        dbEntity.setArrivalTime(transport.getArrivalTime());
        dbEntity.setPrice(transport.getPrice());
        dbEntity.setIsPaid(transport.getIsPaid());
        dbEntity.setType(transport.getType());
        dbEntity.setWeight(transport.getWeight());
        this.repo.save(dbEntity);
    }

    public void delete(Transport transport) {
        this.repo.delete(transport);
    }

    public List<Transport> all() {
        return this.repo.findAll();
    }

    public Transport find(long id) {
        return this.repo.findById(id).get();
    }

    public List<Transport> searchByDestination(String destination) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Transport> cr = cb.createQuery(Transport.class);
        Root<Transport> root = cr.from(Transport.class);
        cr.select(root).where(cb.like(root.get("arrivalLocation"), "%" + destination + "%"));

        List<Transport> companies = this.entityManager.createQuery(cr).getResultList();

        return companies;
    }
}
