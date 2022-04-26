package com.ndangducbn.hibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ProjectConfig {
    private final Environment env;

    public ProjectConfig(Environment env) {
        this.env = env;
    }


    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setPackagesToScan(new String[]{""});
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(getProperties());
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }


    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        return properties;
    }
}
