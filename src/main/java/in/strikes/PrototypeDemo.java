package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * PrototypeDemo — Demonstrates prototype bean scope.
 * 
 * Prototype: NEW instance every time getBean() is called.
 * Use for stateful beans that need independent data per instance.
 */
public class PrototypeDemo {

    @Configuration
    static class PrototypeConfig {

        @Bean
        @Scope("prototype")
        public User createUser() {
            return new User();
        }
    }

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(PrototypeConfig.class);

        System.out.println("--- Prototype Scope Demo ---");

        User user1 = context.getBean(User.class);
        User user2 = context.getBean(User.class);
        User user3 = context.getBean(User.class);

        // All different instances
        System.out.println("user1 == user2: " + (user1 == user2));   // false
        System.out.println("user1 == user3: " + (user1 == user3));   // false
        System.out.println("user2 == user3: " + (user2 == user3));   // false

        user1.setName("Alice");
        user1.setAge(30);
        user2.setName("Bob");
        user2.setAge(25);
        user3.setName("Charlie");
        user3.setAge(35);

        System.out.println();
        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);
        System.out.println("user3: " + user3);

        System.out.println();
        System.out.println("Singleton: All getBean() calls return the SAME instance");
        System.out.println("Prototype: Each getBean() call returns a NEW instance");
    }
}
