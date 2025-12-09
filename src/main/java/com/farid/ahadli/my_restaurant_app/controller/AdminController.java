package com.farid.ahadli.my_restaurant_app.controller;
import com.farid.ahadli.my_restaurant_app.model.dto.request.AdminAddRestaurantIngredientsRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.AdminRestaurantAddMenuItemRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.AdminRestaurantUpdateMenuItemRequestDTO;
import com.farid.ahadli.my_restaurant_app.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    AdminService adminService;

    @GetMapping("/menu")
    public ResponseEntity<?> getMenu() {
        return ResponseEntity.
                ok().
                body(adminService.getMenu());
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<?> getMenuById(@PathVariable Long id) {
        return ResponseEntity.
                ok().
                body(adminService.getMenuById(id));
    }



    @PostMapping("/menu")
    public ResponseEntity<?> addMenu(@RequestBody @Valid AdminRestaurantAddMenuItemRequestDTO adminRestaurantAddMenuItemRequestDTO) {
        adminService.addMenuItem(adminRestaurantAddMenuItemRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("menu item added");

    }

    @PutMapping("/menu/")
    public ResponseEntity<?> updateMenu(@RequestBody @Valid AdminRestaurantUpdateMenuItemRequestDTO adminRestaurantUpdateMenuItemRequestDTO ) {
        adminService.updateMenuItem(adminRestaurantUpdateMenuItemRequestDTO);
        return ResponseEntity.
                ok().
                body("update successful") ;
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable Long id ) {
        adminService.deleteMenuItem(id);
        return ResponseEntity.
                noContent().
                build() ;
    }



    @PostMapping("/ingredients/")
    public ResponseEntity<?> addIngredient(@RequestBody @Valid AdminAddRestaurantIngredientsRequestDTO addRestaurantIngredientsRequestDTO) {
        adminService.addIngredient(addRestaurantIngredientsRequestDTO);
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body("add ingredient successful");
    }

    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable Long id ) {
        adminService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }



}
