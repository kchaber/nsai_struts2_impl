package pl.dmcs.nsai.struts2.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.DefaultJpaDialect;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("pl.dmcs.nsai.struts2.repositories")
public class EclipseLinkDatabaseConfigurator {
	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.POSTGRESQL);
 
        return vendorAdapter;
    }

	@Bean
	public Properties vendorProperties() {
		Properties properties = new Properties();
        properties.setProperty("eclipselink.logging.level", "fine");
        properties.setProperty("eclipselink.weaving", "false");
        properties.setProperty("eclipselink.ddl-generation", "create-or-extend-tables");
        
        return properties;
	}
	
	@Bean
    public JpaDialect jpaDialect() {
        JpaDialect jpaDialect = new EclipseLinkJpaDialect();
        
        return jpaDialect;
    }
	
	@Bean
	public PersistenceExceptionTranslator persistenceExceptionTranslator() {
		return new DefaultJpaDialect();
	}
}
