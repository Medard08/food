package org.polytech;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.polytech.buisness.User;
import org.polytech.buisness.UserService;
import org.polytech.persistence.JpaUserRepository;
import org.polytech.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(){
        return  new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository(){
        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();
        return new JpaUserRepository(session);
    }

    @Bean
    public SessionFactory buildSessionFactory(){
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        // Hibernate settings equivalent to hibernate.cfg.xml's properties

        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/polyfood?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        settings.put(Environment.USER, "medard");
        settings.put(Environment.PASS, "medard");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        //settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        //settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }





}
