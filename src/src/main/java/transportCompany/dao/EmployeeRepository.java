package transportCompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import transportCompany.models.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}