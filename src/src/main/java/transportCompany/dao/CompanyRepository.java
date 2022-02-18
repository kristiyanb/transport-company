package transportCompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import transportCompany.models.*;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
