package transportCompany.dao;

import transportCompany.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class EmployeeDao {
    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private CompanyRepository companyRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Employee employee) {
        var existingCompany = this.companyRepo.findById(employee.getCompany().getId()).get();
        employee.setCompany(existingCompany);
        this.repo.save(employee);
    }

    public void update(Employee employee) {        
        Employee dbEntity = this.repo.findById(employee.getId()).get();
        dbEntity.setName(employee.getName());
        dbEntity.setQualification(employee.getQualification());
        dbEntity.setSalary(employee.getSalary());
        this.repo.save(dbEntity);
    }

    public void delete(Employee employee) {
        this.repo.delete(employee);
    }

    public List<Employee> all() {
        return this.repo.findAll();
    }

    public Employee find(long id) {
        return this.repo.findById(id).get();
    }

    public List<Employee> allSortedByQualification() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.orderBy(cb.asc(root.get("qualification")));

        List<Employee> companies = this.entityManager.createQuery(cr).getResultList();

        return companies;
    }

    public List<Employee> allSortedBySalary() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.orderBy(cb.asc(root.get("salary")));

        List<Employee> companies = this.entityManager.createQuery(cr).getResultList();

        return companies;
    }
}
