package com.farid.ahadli.my_restaurant_app.controller;

import com.farid.ahadli.my_restaurant_app.model.dto.request.CustomerCreateOrderRequestDTO;
import com.farid.ahadli.my_restaurant_app.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        customerService.deleteAllCartItems();
        return ResponseEntity.
                status(HttpStatus.NO_CONTENT)
                .build();

    }

    @PostMapping("/order")
    public ResponseEntity<?>  createOrder( @RequestBody @Valid CustomerCreateOrderRequestDTO order){
        return ResponseEntity.
                status(HttpStatus.OK).
                body(customerService.createOrder(order));
    }

    @DeleteMapping("/order/id")
    public ResponseEntity<?>  cancelOrder(@PathVariable Long id){

        return ResponseEntity.
                status(HttpStatus.NO_CONTENT).
                build();
    }

//    @GetMapping("/order")
//    public ResponseEntity<?>  getOrder(){
//        return ResponseEntity.
//                status(HttpStatus.OK).
//                body(null);
//    }







}
