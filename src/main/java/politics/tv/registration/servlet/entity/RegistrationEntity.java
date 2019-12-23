/**
 * 
 */
package politics.tv.registration.servlet.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author davidstanzler
 * 
 *         Entity class mapping for Spring Boot Data JPA persistence
 *
 */


@Entity
@Table(name = "registrations")
public class RegistrationEntity implements Serializable {

  private static final long serialVersionUID = -3064069678237324406L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String firstname;
  private String lastname;
  private String email;

  public void set_firstname(String fname) {

    firstname = fname;

  }

  public void set_lastname(String lname) {

    lastname = lname;

  }

  public void set_email(String em) {

    email = em;
  }

  public String get_firstname() {

    return firstname;
  }

  public String get_lastname() {

    return lastname;
  }

  public String get_email() {

    return email;
  }
}
