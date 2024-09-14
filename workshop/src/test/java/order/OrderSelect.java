package order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderSelect {
    public static void main(String[] args) {
        try {
            OrderService orderService = new OrderService();
            List<Order> ordersList = orderService.get();

            for (Order order : ordersList) {
                System.out.println("Order ID: " + order.getId() +
                        ", Cart ID: " + order.getCart_Id() +
                        ", Order Date: " + order.getOrder_Date());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}