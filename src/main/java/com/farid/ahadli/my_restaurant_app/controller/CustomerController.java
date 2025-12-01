package com.farid.ahadli.my_restaurant_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class CustomerController {

    @GetMapping("/menu")
    public ResponseEntity<?> getMenu() {
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<?> getMenuItemById(@PathVariable Integer id) {
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }

//    @GetMapping("/menu/{id}/allergens")
//    public ResponseEntity<?> getMenuItemAllergens(@PathVariable Integer id) {
//        return ResponseEntity.
//                status(HttpStatus.OK).
//                body(null);
//    }




    @GetMapping("/cart/items")
    public ResponseEntity<?>  getAllCartItems(){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }

    @GetMapping("/cart/items/{id}")
    public ResponseEntity<?>  getCartItemById(@PathVariable int id){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }

    @PostMapping("/cart/items/")
    public ResponseEntity<?>  addCartItem(@RequestBody Integer id,@RequestBody Integer quantity){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }

    @DeleteMapping("/cart/items/{id}")
    public ResponseEntity<?>  deleteCartItem(@PathVariable Integer id){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }

    @PutMapping("/cart/items/{id}")
    public ResponseEntity<?>  updateCartItem(@PathVariable Integer id, @RequestBody Integer quantity){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(null);
    }
    @DeleteMapping("/cart/items/")
    public ResponseEntity<?>  deleteAllCartItems(){
        return ResponseEntity.
                status(HttpStatus.OK).
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
