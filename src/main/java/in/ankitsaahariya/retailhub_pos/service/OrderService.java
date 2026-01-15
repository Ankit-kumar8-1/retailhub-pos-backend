package in.ankitsaahariya.retailhub_pos.service;

import in.ankitsaahariya.retailhub_pos.io.OrderRequest;
import in.ankitsaahariya.retailhub_pos.io.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrder();
}
