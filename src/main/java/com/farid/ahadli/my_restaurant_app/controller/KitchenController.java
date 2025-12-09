package com.farid.ahadli.my_restaurant_app.controller;


import com.farid.ahadli.my_restaurant_app.model.dto.request.KitchenUpdateOrderRequestDTO;
import com.farid.ahadli.my_restaurant_app.service.KitchenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/kitchen")
public class KitchenController {
    KitchenService kitchenService;

    @GetMapping("/orders")
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.
                ok().
                body(kitchenService.getRestaurantOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrdersById(@PathVariable String id) {
        return ResponseEntity.
                ok().
                body(kitchenService.getRestaurantOrderById(id));
    }


    @PutMapping("/orders/{id}")
    public ResponseEntity<?> updateOrderStatus(@PathVariable String id, @RequestBody @Valid KitchenUpdateOrderRequestDTO kitchenUpdateOrderDTO ) {
        kitchenService.updateOrderStatus(id, kitchenUpdateOrderDTO);
        return ResponseEntity.
                status(HttpStatus.NO_CONTENT)
                .build();
    }



}
