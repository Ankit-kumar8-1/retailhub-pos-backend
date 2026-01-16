package in.ankitsaahariya.retailhub_pos.service;

import in.ankitsaahariya.retailhub_pos.io.OrderRequest;
import in.ankitsaahariya.retailhub_pos.io.OrderResponse;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrder();

    Double sumSalesByDate(LocalDate date);

    Long countByOrderDate(LocalDate date);

    List<OrderResponse> findRecentOrders();
}
