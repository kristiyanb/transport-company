package transportCompany.dao;

import transportCompany.dto.CompanyEmployeesDto;
import transportCompany.models.Company;
import transportCompany.models.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyDao {
    @Autowired
    private CompanyRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Company company) {
        this.repo.save(company);
    }

    public void update(Company company) {
        Company dbEntity = this.repo.findById(company.getId()).get();
        dbEntity.setName(company.getName());
        this.repo.save(dbEntity);
    }

    public void delete(Company company) {
        this.repo.delete(company);
    }

    public Company find(long id) {
        return this.repo.findById(id).get();
    }

    public List<Company> all() {
        return this.repo.findAll();
    }

    public List<Company> searchByName(String name) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> cr = cb.createQuery(Company.class);
        Root<Company> root = cr.from(Company.class);
        cr.select(root).where(cb.like(root.get("name"), "%" + name + "%"));

        return this.entityManager.createQuery(cr).getResultList();
    }

    public int getTotalTransportsDone(long id) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> cr = cb.createQuery(Company.class);
        Root<Company> root = cr.from(Company.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

        List<Company> companies = this.entityManager.createQuery(cr).getResultList();

        return companies.get(0).getTransports().size();
    }

    public Double getTotalProfits(long id) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> cr = cb.createQuery(Company.class);
        Root<Company> root = cr.from(Company.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

        List<Company> companies = this.entityManager.createQuery(cr).getResultList();

        return companies.get(0).getTransports().stream().mapToDouble(o -> o.getPrice()).sum();
    }

    public List<CompanyEmployeesDto> getEmployees(long id) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> cr = cb.createQuery(Company.class);
        Root<Company> root = cr.from(Company.class);
        cr.select(root).where(cb.equal(root.get("id"), id));

        List<Company> companies = this.entityManager.createQuery(cr).getResultList();
        List<CompanyEmployeesDto> companyEmployees = new ArrayList<CompanyEmployeesDto>();

        for (Employee employee : companies.get(0).getEmployees()) {
            CompanyEmployeesDto dto = new CompanyEmployeesDto();

            dto.setEmployee(employee.getName());
            dto.setTransportsDone(employee.getTransports().size());
            dto.setProfits((employee.getTransports().stream().mapToDouble(o -> o.getPrice()).sum()));

            companyEmployees.add(dto);
        }

        return companyEmployees;
    }
}
