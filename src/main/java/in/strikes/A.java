package in.strikes;

import org.springframework.stereotype.Component;

/**
 * Component A — Depends on singleton OrderService via constructor injection.
 * 
 * @Component: auto-discovered by @ComponentScan.
 * Spring injects the shared singleton OrderService instance.
 */
@Component
public class A {

    private final OrderService orderService;

    public A(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
