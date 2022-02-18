package transportCompany.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import transportCompany.dao.EmployeeDao;
import transportCompany.models.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private EmployeeDao employeeDao;

    public EmployeesController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;

    }

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeDao.all();
    }

    @PostMapping
    public void create(@RequestBody Employee client) {
        this.employeeDao.add(client);
    }

    @PutMapping
    public void update(@RequestBody Employee client) {
        this.employeeDao.update(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Employee client) {
        this.employeeDao.delete(client);
    }

    @GetMapping
    @RequestMapping("/allSortedByQualification")
    public List<Employee> allSortedByQualification() {
        return this.employeeDao.allSortedByQualification();
    }

    @GetMapping
    @RequestMapping("/allSortedBySalary")
    public List<Employee> allSortedBySalary() {
        return this.employeeDao.allSortedBySalary();
    }
}
