package transportCompany.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import transportCompany.dao.CompanyDao;
import transportCompany.dto.CompanyEmployeesDto;
import transportCompany.models.Company;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
    private CompanyDao companyDao;

    public CompaniesController(CompanyDao companyDao) {
        this.companyDao = companyDao;

    }

    @GetMapping
    public List<Company> getAll() {
        return this.companyDao.all();
    }

    @PostMapping
    public void create(@RequestBody Company client) {
        this.companyDao.add(client);
    }

    @PutMapping
    public void update(@RequestBody Company client) {
        this.companyDao.update(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Company client) {
        this.companyDao.delete(client);
    }

    @GetMapping
    @RequestMapping("/searchByName")
    public List<Company> searchByName(@RequestParam String name) {
        return this.companyDao.searchByName(name);
    }

    @GetMapping
    @RequestMapping("/totalTransportsDone")
    public int totalTransportsDone(@RequestParam long id) {
        return this.companyDao.getTotalTransportsDone(id);
    }

    @GetMapping
    @RequestMapping("/totalProfits")
    public Double totalProfits(@RequestParam long id) {
        return this.companyDao.getTotalProfits(id);
    }

    @GetMapping
    @RequestMapping("/employees")
    public List<CompanyEmployeesDto> employees(@RequestParam long id) {
        return this.companyDao.getEmployees(id);
    }
}
