package pl.dmcs.nsai.struts2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseConfigurator.class})
@ComponentScan(basePackages = {"pl.dmcs.nsai.struts2.services"})
public class ApplicationConfigurator {
	
}
