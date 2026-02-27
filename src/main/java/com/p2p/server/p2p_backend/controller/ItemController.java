package com.p2p.server.p2p_backend.controller;

import com.p2p.server.p2p_backend.dto.request.CreateItemRequest;
import com.p2p.server.p2p_backend.dto.response.CreateItemResponse;
import com.p2p.server.p2p_backend.dto.response.GetItemResponse;
import com.p2p.server.p2p_backend.service.ItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    // GET item by ID
    @GetMapping("/{id}")
    public GetItemResponse getItemById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    // POST create new item
    @PostMapping
    public CreateItemResponse createItem(@RequestBody CreateItemRequest request) {
        return itemService.createItem(request);
    }

    // PUT update existing item
    @PutMapping("/{id}")
    public CreateItemResponse updateItem(@PathVariable String id, @RequestBody CreateItemRequest request) {
        return itemService.updateItem(id, request);
    }

    // DELETE item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }
}