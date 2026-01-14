package in.ankitsaahariya.retailhub_pos.controller;


import ch.qos.logback.core.encoder.EchoEncoder;
import in.ankitsaahariya.retailhub_pos.io.ItemRequest;
import in.ankitsaahariya.retailhub_pos.io.ItemResponse;
import in.ankitsaahariya.retailhub_pos.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/admin/items")
    public ResponseEntity<ItemResponse> addItem(@RequestBody ItemRequest request) {
        try {
            ItemResponse response = itemService.add(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/items")
    public List<ItemResponse> readItems(){
        return itemService.fetchItems();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/items/{itemId}")
    public void removeItem(@PathVariable String itemId){
        try {
            itemService.deleteItem(itemId);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Item not found");
        }
    }
}
