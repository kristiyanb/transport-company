package transportCompany.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;

    private String qualification;

    private Double salary;
    
    @JsonBackReference(value="employee-company")
    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "employee")
    private List<Transport> transports;

    public Employee() {
        super();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee(String name, String qualification, Double salary, Company company) {
        this.name = name;
        this.qualification = qualification;
        this.salary = salary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    public List<Transport> getTransports() {
        return this.transports;
    }
}
