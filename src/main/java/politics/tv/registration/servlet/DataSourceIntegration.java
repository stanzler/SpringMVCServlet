/**
 * 
 */
package politics.tv.registration.servlet;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author davidstanzler
 * 
 * Inject the datasource from application.properties into the Spring Boot application
 *
 */

@Configuration
public class DataSourceIntegration {

  @Bean
  @ConfigurationProperties("spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }



}
