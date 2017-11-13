package ru.fella;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.fella.dao.SimpleDao;
import ru.fella.dao.SimpleDaoImpl;
import ru.fella.processors.ResponseProcessor;


@ComponentScan(basePackages = {"ru.fella"})
@SpringBootApplication
public class DreamWorkApplication {

  // Инициализация DataSource для подключения к базе
  @Bean(name = "dataSource")
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.h2.Driver");
    ds.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    ds.setUsername("sa");
    ds.setPassword("");

    return ds;
  }

  // Инициализация DAO
  @Bean(name = "dao")
  public SimpleDao setupDao() {
    return new SimpleDaoImpl();
  }

  // Инициализация процессора для обработки ответов
  @Bean(name = "responseProcessor")
  public ResponseProcessor getResponseProcessor() {
    return new ResponseProcessor();
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(DreamWorkApplication.class, args);
  }
}
