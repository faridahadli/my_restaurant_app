package com.farid.ahadli.my_restaurant_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/menu")
    public ResponseEntity<?> getMenu() {
        return ResponseEntity.
                ok().
                body(null);
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<?> getMenuById(@PathVariable Integer id) {
        return ResponseEntity.
                ok().
                body(null);
    }

    @PostMapping("/menu") // introduce some DTO
    public ResponseEntity<?> addMenu(@RequestBody int i ) {
        return ResponseEntity.
                ok().
                body(null);
    }

    @PutMapping("/menu/{id}") // add some dto
    public ResponseEntity<?> updateMenu(@PathVariable Integer id, @RequestBody int i ) {
        return ResponseEntity.
                ok().
                body(null);
    }


    @PutMapping("/ingredients/{id}") // add some dto
    public ResponseEntity<?> addIngredient(@PathVariable Integer id, @RequestBody int i ) {
        return ResponseEntity.
                ok().
                body(null);
    }

    @GetMapping("/report") // need dto
    public ResponseEntity<?> generateReport(@RequestBody Date dateRange ) {
        return ResponseEntity.
                ok().
                body(null);
    }


}
