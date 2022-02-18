package transportCompany.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vehicle {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

    public Vehicle() {
        super();
    }
    
    public Vehicle(Company company) {
        this.company = company;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
