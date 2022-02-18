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
public class Transport {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String departureLocation;

    private String departureTime;

    private String arrivalLocation;

    private String arrivalTime;

    private Double price;

    private Boolean isPaid;

    private TransportType type;

    @Column(nullable = true)
    private Double weight;

    @JsonBackReference(value="transport-company")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @JsonBackReference(value="vehicle-transport")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @JsonBackReference(value="employee-transport")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @JsonBackReference(value="client-transport")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Transport() {
        super();
    }
    
    public Transport(String departureLocation,
            String departureTime,
            String arrivalLocation,
            String arrivalTime,
            Double price,
            Boolean isPaid,
            TransportType type,
            Double weight,
            Company company,
            Vehicle vehicle,
            Employee employee,
            Client client) {
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.arrivalLocation = arrivalLocation;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.isPaid = isPaid;
        this.type = type;
        this.weight = weight;
        this.company = company;
        this.vehicle = vehicle;
        this.employee = employee;
        this.client = client;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
