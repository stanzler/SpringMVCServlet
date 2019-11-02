/**
 * 
 */
package politics.tv.registration.servlet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import politics.tv.registration.servlet.entity.RegistrationEntity;
import politics.tv.registration.servlet.repository.RegistrationRepository;

/**
 * @author davidstanzler
 *
 *Sample CRUD operations on a SpringWebMVC Controller using Spring Boot
 *
 */

@RestController
@RequestMapping(value = "/registrations/")
@EnableAutoConfiguration
public class RegistrationController {
	
	@Autowired
	RegistrationRepository registrationRepository;

	@RequestMapping(value = "/viewAll/", method = RequestMethod.GET)
	public ArrayList<RegistrationEntity> ReadRegistrations() {
		
		ArrayList<RegistrationEntity> read_registrations = 
				registrationRepository.findAll();
		
		return read_registrations;
		
	}
	
	@RequestMapping(value = "/view/byID/{id}", method = RequestMethod.POST)
	public ArrayList<RegistrationEntity> GetById(@PathVariable long id){
		
		ArrayList<RegistrationEntity> read_registration = 
				registrationRepository.findAllById(id);
		
		return read_registration;
		
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity.BodyBuilder CreateRegistration(@RequestParam String firstname, 
			@RequestParam String lastname, 
			@RequestParam String email) {
		
		RegistrationEntity registrationEntity = new RegistrationEntity();
		registrationEntity.set_firstname(firstname);
		registrationEntity.set_lastname(lastname);
		registrationEntity.set_email(email);
		
		registrationRepository.save(registrationEntity);
		
		return ResponseEntity.ok();
		
	}
	
	@RequestMapping(path = "/validate/{id}", method = RequestMethod.POST)
	public boolean RegistrationExists(@PathVariable long id) {
		
		return registrationRepository.existsById(id);
		
	}
	
	@RequestMapping(path = "registrations/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity.BodyBuilder DeleteRegistration(@PathVariable long id) {
		
		registrationRepository.deleteById(id);
		
		return ResponseEntity.ok();
		
	}
	
}