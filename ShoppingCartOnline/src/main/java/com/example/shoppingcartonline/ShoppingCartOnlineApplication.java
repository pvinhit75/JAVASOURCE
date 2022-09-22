package com.example.shoppingcartonline;

import net.bytebuddy.build.ToStringPlugin;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication

@EnableAutoConfiguration(exclude = { //
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class })

public class ShoppingCartOnlineApplication {
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartOnlineApplication.class, args);
    }


    @Bean(name = "onlineshop")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        //See:Application.properties
        dataSource.setDriverClassName(env.getProperties("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperties("spring.datasource.url"));
        dataSource.setUsername(env.getProperties("spring.datasource.username"));
        dataSource.setPassword(env.getProperties("spring.datasource.password"));

        System.out.println("## getDataSource: " +dataSource);

        return dataSource;

    }
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception{
        Properties properties = new Properties();

        //See:application.properties
        properties.put("hibernate.dialect", env.getProperties("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperties("spring.jpa.show-sql"));
        properties.put("current_session_context_class",
                env.getProperties("spring.jpa.properties.hibernate.current_session_context_class"));

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        //Packege contain entity classes
        factoryBean.setPackagesToScan(new String[]{""});
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();

        //
        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory:" +sf);

    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFatory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFatory);

    return transactionManager;
    }

}
