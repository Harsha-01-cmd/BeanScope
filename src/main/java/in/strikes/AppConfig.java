package in.strikes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig — Java-based Spring configuration.
 * 
 * @Configuration: marks this as a Spring config class with @Bean methods.
 * @ComponentScan: auto-discovers @Component classes (A and B) in this package.
 * 
 * Two @Bean methods return OrderService, but only ONE instance is created
 * because singleton scope caches the first one and skips the second.
 */
@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public OrderService getOrder() {
        return new OrderService();
    }

    @Bean
    public OrderService getOrder2() {
        // Never called — singleton cache already has OrderService from getOrder()
        return new OrderService();
    }
}
