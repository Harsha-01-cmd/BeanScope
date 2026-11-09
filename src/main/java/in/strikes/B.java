package in.strikes;

import org.springframework.stereotype.Component;

/**
 * Component B — Also depends on singleton OrderService.
 * 
 * Both A and B share the SAME OrderService instance — proving
 * that singleton scope works across all dependency injection points.
 */
@Component
public class B {

    private final OrderService orderService;

    public B(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
