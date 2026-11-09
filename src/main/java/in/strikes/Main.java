package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main — Demonstrates Spring's singleton bean scope.
 * 
 * Singleton (default): ONE instance per container, shared everywhere.
 * Both getBean() calls return the same cached instance.
 */
public class Main {

    public static void main(String[] args) {

        // Create Spring container with AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // First getBean() call — Spring creates and caches the instance
        OrderService order = context.getBean(OrderService.class);

        // Second getBean() call — Spring returns the cached instance
        OrderService order2 = context.getBean(OrderService.class);

        // Compare references — both point to the same object
        System.out.println(order == order2);  // true

        // Verify components A and B share the same OrderService
        A componentA = context.getBean(A.class);
        B componentB = context.getBean(B.class);

        System.out.println("\n--- Singleton Verification ---");
        System.out.println("order == order2: " + (order == order2));
        System.out.println("A's service == B's service: "
                + (componentA.getOrderService() == componentB.getOrderService()));
        System.out.println("A's service == direct getBean: "
                + (componentA.getOrderService() == order));
        System.out.println("All references point to the same singleton instance!");

        order.placeOrder();
    }
}
