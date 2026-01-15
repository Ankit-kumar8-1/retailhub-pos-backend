package in.ankitsaahariya.retailhub_pos.controller;

import in.ankitsaahariya.retailhub_pos.io.OrderRequest;
import in.ankitsaahariya.retailhub_pos.io.OrderResponse;
import in.ankitsaahariya.retailhub_pos.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String orderId){
        orderService.deleteOrder(orderId);
    }

    @GetMapping("/latest")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getLatestOrder(){
        return orderService.getLatestOrder();
    }
}
