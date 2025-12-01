package com.farid.ahadli.my_restaurant_app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @GetMapping("/orders")
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.
                ok().
                body(null);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrdersById(@PathVariable Integer id) {
        return ResponseEntity.
                ok().
                body(null);
    }


    @PutMapping("/orders/{id}")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Integer id) {
        return ResponseEntity.
                ok().
                body(null);
    }



//    @PutMapping("/kitchen/orders")
//    public ResponseEntity<?> getPendingOrders() {
//        return ResponseEntity.
//                ok().
//                body(null);
//    }

}
