package edu.spring.jackson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("edu.spring.jackson.*")
@ComponentScan(lazyInit = true)
@Configuration
public class JacksonApplicationTestConfiguration {
   // @Bean

}
