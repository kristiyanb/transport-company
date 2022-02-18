package transportCompany.dto;

public class CompanyEmployeesDto {
    private String employee;

    private int transportsDone;

    private Double profits;

    public Double getProfits() {
        return profits;
    }

    public int getTransportsDone() {
        return transportsDone;
    }

    public void setTransportsDone(int transportsDone) {
        this.transportsDone = transportsDone;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setProfits(Double profits) {
        this.profits = profits;
    }
}
