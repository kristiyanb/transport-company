package transportCompany.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Company {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Company() {
        super();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonManagedReference(value="client-company")
    @OneToMany(mappedBy = "company")
    private List<Client> clients;

    @JsonManagedReference(value="employee-company")
    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    @JsonManagedReference(value="transport-company")
    @OneToMany(mappedBy = "company")
    private List<Transport> transports;

    @JsonManagedReference(value="vehicle-company")
    @OneToMany(mappedBy = "company")
    private List<Vehicle> vehicles;

    public Company(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transport> getTransports() {
        return this.transports;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public List<Client> getClients() {
        return this.clients;
    }
    
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }
}
