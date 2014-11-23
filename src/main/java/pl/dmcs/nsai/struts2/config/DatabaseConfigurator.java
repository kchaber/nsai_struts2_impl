package pl.dmcs.nsai.struts2.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@Import({EclipseLinkDatabaseConfigurator.class})
public class DatabaseConfigurator {
	
	@Bean
    public DataSource basicDataSource() {
		DriverManagerDataSource driverDataSource = new DriverManagerDataSource();
		driverDataSource.setDriverClassName("org.postgresql.Driver");
		driverDataSource.setUrl("jdbc:postgresql://localhost:5432/nsai_parking_management_db");
		driverDataSource.setUsername("postgres");
		driverDataSource.setPassword("postgres");
 
        return driverDataSource;
    }
	
	@Bean
	@Autowired
	public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter, Properties vendorProperties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan("pl.dmcs.nsai.struts2.entities");
        factory.setDataSource(dataSource);
 
        factory.setJpaProperties(vendorProperties);
        
        factory.afterPropertiesSet();
        
        EntityManagerFactory result = factory.getObject();
        
        return result;
    }
	
	@Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory, JpaDialect jpaDialect) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        txManager.setJpaDialect(jpaDialect);
        
        return txManager;
    }
}
