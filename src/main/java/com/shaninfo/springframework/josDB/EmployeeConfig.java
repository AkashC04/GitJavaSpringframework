package com.shaninfo.springframework.josDB;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.shaninfo.springframework.josDB")
@EnableTransactionManagement
public class EmployeeConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/hibernateDB1?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Kolkata");
        ds.setUsername("root");
        ds.setPassword("Akash@2002");
        return ds;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory =new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.shaninfo.springframework.josDB");
        Properties props = new Properties();
        props.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");
        sessionFactory.setHibernateProperties(props);
        return sessionFactory;
    }
    @Bean
    public PlatformTransactionManager transactionManager(
            SessionFactory sessionFactory) {
     return new HibernateTransactionManager(sessionFactory);
    }
}