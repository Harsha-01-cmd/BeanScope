package in.strikes;

import org.springframework.context.annotation.Scope;

/**
 * OrderService — Singleton-scoped service bean.
 * 
 * @Scope("singleton"): ONE instance per container (default scope).
 * Stateless services are safe to share — no mutable instance fields.
 * 
 * Constructor prints a message so we can verify only ONE instance is created.
 */
@Scope("singleton")
public class OrderService {

    public OrderService() {
        System.out.println("OrderService created");
    }

    public void placeOrder() {
        System.out.println("Order placed");
    }
}
