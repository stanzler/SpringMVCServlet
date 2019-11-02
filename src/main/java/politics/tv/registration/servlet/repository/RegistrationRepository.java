package politics.tv.registration.servlet.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import politics.tv.registration.servlet.entity.RegistrationEntity;

/**
 * @author davidstanzler
 *
 *Spring Boot Data JPA Repository exposes quick, generic, query methods for persistence 
 */
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long>{
	
	ArrayList<RegistrationEntity> findAll();
	ArrayList<RegistrationEntity> findAllById(long id);
	void deleteById(long id);
	boolean existsById(long id);
}
