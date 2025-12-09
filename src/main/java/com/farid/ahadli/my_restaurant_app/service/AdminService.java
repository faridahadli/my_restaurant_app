package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.model.TaxType;
import com.farid.ahadli.my_restaurant_app.model.dto.request.AdminAddRestaurantIngredientsRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.AdminRestaurantAddMenuItemRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.AdminRestaurantUpdateMenuItemRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.AdminRestaurantMenuItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantIngredientsRepository;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantMenuItemRepository;
import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import com.farid.ahadli.my_restaurant_app.utility.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class AdminService {
    RestaurantMenuItemRepository restaurantMenuItemRepository;
    RestaurantIngredientsRepository restaurantIngredientsRepository;

    public List<AdminRestaurantMenuItemResponseDTO> getMenu() {
       List<RestaurantMenuItem> menuItems =  restaurantMenuItemRepository.findAllEager();
        GlobalUtil.ifMenuEmpty(menuItems);
        return menuItems.stream().map( MapperUtil::convertRestaurantMenuItemToAdminRestaurantMenuItemResponseDTO ).toList();
    }

    public List<AdminRestaurantMenuItemResponseDTO> getMenuById(Long id) {
        Optional<RestaurantMenuItem> menuItem =  restaurantMenuItemRepository.findByIdEager(id);
        GlobalUtil.ifMenuItemPresent(menuItem);
        return menuItem.stream().map( MapperUtil::convertRestaurantMenuItemToAdminRestaurantMenuItemResponseDTO ).toList();
    }

    @Transactional
    public void addMenuItem(AdminRestaurantAddMenuItemRequestDTO adminRestaurantAddMenuItemRequestDTO){
        List<RestaurantIngredients> restaurantIngredients = restaurantIngredientsRepository.findAllById(adminRestaurantAddMenuItemRequestDTO.getIngredientIds());
        GlobalUtil.ifCorrectIngredientIds(restaurantIngredients,adminRestaurantAddMenuItemRequestDTO.getIngredientIds().size() );
        TaxType taxType = adminRestaurantAddMenuItemRequestDTO.getTaxType();
        restaurantMenuItemRepository.save(RestaurantMenuItem.builder()
                        .taxType(adminRestaurantAddMenuItemRequestDTO.getTaxType())
                        .price(adminRestaurantAddMenuItemRequestDTO.getPrice())
                        .name(adminRestaurantAddMenuItemRequestDTO.getName())
                        .taxRate(taxType.getTaxRate())
                        .taxAmount(taxType.calculateTaxAmount(adminRestaurantAddMenuItemRequestDTO.getPrice()))
                        .ingredientSet(  restaurantIngredients.stream().collect(Collectors.toSet()))
                .build());
        String[] userDetails = GlobalUtil.getUsernameAndAuthorities();

        log.info("{} with the authorities : {} added a menu item with the name {}" , userDetails[0], userDetails[1],adminRestaurantAddMenuItemRequestDTO.getName());

    }

    @Transactional
    public void updateMenuItem(AdminRestaurantUpdateMenuItemRequestDTO adminRestaurantUpdateMenuItemRequestDTO){
        Optional<RestaurantMenuItem> menuItem = restaurantMenuItemRepository.findById(adminRestaurantUpdateMenuItemRequestDTO.getRestaurantId());
        GlobalUtil.ifMenuItemPresent(menuItem);
        List<RestaurantIngredients> restaurantIngredients = restaurantIngredientsRepository.findAllById(adminRestaurantUpdateMenuItemRequestDTO.getIngredientIds());
        GlobalUtil.ifCorrectIngredientIds(restaurantIngredients,
                adminRestaurantUpdateMenuItemRequestDTO.getIngredientIds().size() );
        TaxType taxType = adminRestaurantUpdateMenuItemRequestDTO.getTaxType();
        restaurantMenuItemRepository.save(
                RestaurantMenuItem.builder()
                        .id(adminRestaurantUpdateMenuItemRequestDTO.getRestaurantId())
                        .name(adminRestaurantUpdateMenuItemRequestDTO.getName())
                        .taxType(taxType)
                        .price(adminRestaurantUpdateMenuItemRequestDTO.getPrice())
                        .taxRate(taxType.getTaxRate())
                        .taxAmount(taxType.calculateTaxAmount(adminRestaurantUpdateMenuItemRequestDTO.getPrice()))
                        .ingredientSet(restaurantIngredients.stream().collect(Collectors.toSet()))
                        .build()
        );
        String[] userDetails = GlobalUtil.getUsernameAndAuthorities();
        log.info("{} with the authorities : {} updated a menu item with the name {}" , userDetails[0], userDetails[1],adminRestaurantUpdateMenuItemRequestDTO.getName());
    }

    public void deleteMenuItem(Long id){
        Optional<RestaurantMenuItem> menuItem = restaurantMenuItemRepository.findById(id);
        GlobalUtil.ifMenuItemPresent(menuItem);
        String name = menuItem.get().getName();
        restaurantMenuItemRepository.deleteById(id);
        String[] userDetails = GlobalUtil.getUsernameAndAuthorities();
        log.info("{} with the authorities : {} deleted a menu item with the name {}" , userDetails[0], userDetails[1],name);
    }


    public void addIngredient(AdminAddRestaurantIngredientsRequestDTO adminAddRestaurantIngredientsRequestDTO ){
        restaurantIngredientsRepository.save( RestaurantIngredients.builder()
                         .name(adminAddRestaurantIngredientsRequestDTO.getName())
                         .Allergen(adminAddRestaurantIngredientsRequestDTO.getAllergen())
                         .measureUnits(adminAddRestaurantIngredientsRequestDTO.getMeasureUnits())
                         .pricePerUnit(adminAddRestaurantIngredientsRequestDTO.getPricePerUnit())
                         .menuItemSet(new HashSet<>())
                 .build());
        String[] userDetails = GlobalUtil.getUsernameAndAuthorities();
        log.info("{} with the authorities : {} added an ingredient with the name {}" , userDetails[0], userDetails[1],adminAddRestaurantIngredientsRequestDTO.getName());

    }

    public void deleteIngredient(Long id){
        Optional<RestaurantIngredients> ingredient = restaurantIngredientsRepository.findById(id);
        GlobalUtil.ifIngredientPresent(ingredient);
        String name = ingredient.get().getName();
        restaurantIngredientsRepository.deleteById(id);
        String[] userDetails = GlobalUtil.getUsernameAndAuthorities();
        log.info("{} with the authorities : {} deleted an ingredient with the name {}" , userDetails[0], userDetails[1],name);

    }



}
