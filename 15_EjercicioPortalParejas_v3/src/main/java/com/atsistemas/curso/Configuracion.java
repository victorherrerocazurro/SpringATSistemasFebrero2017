package com.atsistemas.curso;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScans({
	@ComponentScan("com.atsistemas.curso.negocio"),
	@ComponentScan("com.atsistemas.curso.persistencia.hibernate"),
	@ComponentScan("com.atsistemas.curso.servicios")
})
@EnableTransactionManagement
public class Configuracion {
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		//sessionFactoryBean.setAnnotatedClasses(Cliente.class, Factura.class);
		sessionFactoryBean.setPackagesToScan("com.atsistemas.curso.entidades");
		
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		//properties.setProperty("hibernate.current_session_context_class", "thread");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		
		sessionFactoryBean.setHibernateProperties(properties);
		
		return sessionFactoryBean;
	}
	
	@Bean
	public DataSource dataSource(
			@Value("${db.user}") String username, 
			@Value("${db.password}") String password, 
			@Value("${db.url}") String url, 
			@Value("${db.driver.class.name}") String driverClassName){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean
	public PropertyPlaceholderConfigurer properties(){
		PropertyPlaceholderConfigurer placeholderConfigurer 
								= new PropertyPlaceholderConfigurer();
		
		placeholderConfigurer.setLocation(
				new ClassPathResource("Configuracion.properties"));
		
		return placeholderConfigurer;
	}
	
}
