package br.com.uptech.config;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MySQLConfig {

  @Value("${spring.datasource.mysql.url}")
  private String mysqlUrl;

  @Value("${spring.datasource.mysql.username}")
  private String mysqlUsername;

  @Value("${spring.datasource.mysql.password}")
  private String mysqlPassword;

  @Primary
  @Bean(name = "mysqlDataSource")
  public DataSource mysqlDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl(mysqlUrl);
    dataSource.setUsername(mysqlUsername);
    dataSource.setPassword(mysqlPassword);
    return dataSource;
  }

  @Primary
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(mysqlDataSource())
        .packages("br.com.uptech.mysql")
        .persistenceUnit("mysql")
        .properties(getJpaProperties())
        .build();
  }

  @Primary
  @Bean(name = "mysqlTransactionManager")
  public PlatformTransactionManager mysqlTransactionManager() {
    return new JpaTransactionManager(mysqlEntityManagerFactory(null).getObject());
  }

  private Map<String, Object> getJpaProperties() {
    Map<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", "update");
    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    return properties;
  }
}
