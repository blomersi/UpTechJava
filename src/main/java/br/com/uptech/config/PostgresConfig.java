package br.com.uptech.config;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PostgresConfig {

  @Value("${spring.datasource.postgres.url}")
  private String postgresUrl;

  @Value("${spring.datasource.postgres.username}")
  private String postgresUsername;

  @Value("${spring.datasource.postgres.password}")
  private String postgresPassword;

  @Bean(name = "postgresDataSource")
  public DataSource postgresDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(postgresUrl);
    dataSource.setUsername(postgresUsername);
    dataSource.setPassword(postgresPassword);
    return dataSource;
  }

  @Bean(name = "postgresEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(postgresDataSource())
        .packages("br.com.uptech.postgres")
        .persistenceUnit("postgres")
        .properties(getJpaProperties())
        .build();
  }

  @Bean(name = "postgresTransactionManager")
  public PlatformTransactionManager postgresTransactionManager() {
    return new JpaTransactionManager(postgresEntityManagerFactory(null).getObject());
  }

  private Map<String, Object> getJpaProperties() {
    Map<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", "update");
    properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    return properties;
  }
}