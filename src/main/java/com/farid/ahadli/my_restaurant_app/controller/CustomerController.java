package com.farid.ahadli.my_restaurant_app.controller;

import com.farid.ahadli.my_restaurant_app.service.CustomerService;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/")
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal=true)
@Data
public class CustomerController {

    CustomerService customerService;

    @GetMapping("/menu")
    public ResponseEntity<?> getMenu() {
        return ResponseEntity.
                status(HttpStatus.OK).
                body(customerService.getMenuItems());
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<?> getMenuItemById(@PathVariable Long id) {
        return ResponseEntity.
                status(HttpStatus.OK).
                body(customerService.getMenuItemById(id));
    }



    @GetMapping("/cart/items")
    public ResponseEntity<?>  getAllCartItems(){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(customerService.getAllCartItems());
    }
    @GetMapping("/cart")
    public ResponseEntity<?> getCart(){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(customerService.getCart());
    }

    @GetMapping("/cart/items/{id}")
    public ResponseEntity<?>  getCartItemById(@PathVariable Long id){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(customerService.getCartItemById(id));
    }

    @PostMapping("/cart/items/{id}/")
    public ResponseEntity<?>  addCartItem(@PathVariable Long id, @RequestParam @Min(1) Integer quantity){
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(customerService.addCartItem(id, quantity));
    }

    @DeleteMapping("/cart/items/{id}")
    public ResponseEntity<?>  deleteCartItem(@PathVariable Long id){
        customerService.deleteCartItem(id);
        return ResponseEntity.
                status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/cart/items/")
    public ResponseEntity<?>  deleteAllCartItems(){
        return ResponseEntity.
                status(HttpStatus.NO_CONTENT).
                body(null);
    }

    @PostMapping("/order")
    public ResponseEntity<?>  createOrder(){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }

    @DeleteMapping("/order")
    public ResponseEntity<?>  cancelOrder(){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }




}
