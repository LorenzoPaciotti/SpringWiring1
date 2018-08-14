package soundsystem;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

public class DataSourceConfig {

	@Bean(destroyMethod = "shutdown")
	@Profile("dev")
	public DataSource embeddedDataSource() {
		return (DataSource) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema.sql").addScript("classpath:test-data.sql").build();
	}

	@Bean
	@Profile("prod")
	public DataSource jndiDataSource() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/myDS");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean.getObject();
	}

}

/*
 * Spring’s solution for environment-specific beans isn’t much different from build-time
solutions. Certainly, an environment-specific decision is made as to which beans will
and won’t be created. But rather than make that decision at build time, Spring waits to
make the decision at runtime. Consequently, the same deployment unit (perhaps a
WAR file) will work in all environments without being rebuilt.
In version 3.1, Spring introduced bean profiles. To use profiles, you must gather all
the varying bean definitions into one or more profiles and then make sure the proper
profile is active when your application is deployed in each environment.
In Java configuration, you can use the @Profile annotation to specify which pro-
file a bean belongs to.*/
