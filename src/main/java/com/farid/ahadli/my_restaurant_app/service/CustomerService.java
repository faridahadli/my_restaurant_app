package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.model.CartItem;
import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import com.farid.ahadli.my_restaurant_app.model.TableEnum;
import com.farid.ahadli.my_restaurant_app.model.dto.request.CustomerCreateOrderRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.*;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrderMenuItem;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrders;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantOrdersRepository;
import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantMenuItemRepository;
import com.farid.ahadli.my_restaurant_app.utility.MapperUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerService {
    Cart cart;
    RestaurantMenuItemRepository restaurantMenuItemRepository;
    RestaurantOrdersRepository restaurantOrdersRepository;

    //region MenuItem

    public List<CustomerRestaurantMenuItemResponseDTO> getMenuItems() {
       List<RestaurantMenuItem> MenuItems = restaurantMenuItemRepository.findAll();
       GlobalUtil.ifMenuEmpty(MenuItems);
       return MapperUtil
               .convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(MenuItems);
    }

    public CustomerRestaurantMenuItemResponseDTO getMenuItemById(Long id) {
       // GlobalUtil.ifProperMenuItemId(id);
        Optional<RestaurantMenuItem> item = restaurantMenuItemRepository.findById(id);
        GlobalUtil.ifMenuItemPresent(item);
        return MapperUtil
                .convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO(item.get());
    }
 // endregion
        // region Cart
    public Map<Long, CustomerCartItemResponseDTO> getAllCartItems(){
        return MapperUtil.convertCartItemMapToCustomerCartItemResponseDTO(cart.getOrders()) ;
    }

    public CustomerCartResponseDTO getCart() {

        return MapperUtil.convertCartToCartDTO(cart);

    }

    public CustomerCartItemResponseDTO  getCartItemById(Long id){
        GlobalUtil.ifMenuItemPresent(restaurantMenuItemRepository.findById(id));
        GlobalUtil.ifCartItemExist(id, cart);
        return MapperUtil.convertCartItemToCustomerCartItemResponseDTO(cart.getOrders().get(id));
    }


    public CustomerCartItemResponseDTO addCartItem(Long id, Integer quantity) {
        Optional<RestaurantMenuItem> menuItem = restaurantMenuItemRepository.findById(id);
        GlobalUtil.ifMenuItemPresent(restaurantMenuItemRepository.findById(id));
        CartItem cartItem =  CartItem.builder()
                .customerRestaurantMenuItemResponseDTO(
                        MapperUtil.convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO(menuItem.get())
                )
                .quantity(quantity)
                .build();
        cart.addOrUpdateItem(
                cartItem
        );

        return MapperUtil.convertCartItemToCustomerCartItemResponseDTO(cartItem);
    }

    public void deleteCartItem(Long id) {
        GlobalUtil.ifMenuItemPresent(restaurantMenuItemRepository.findById(id));
        GlobalUtil.ifCartItemExist(id, cart);
        cart.removeItem(id);
    }

   public void deleteAllCartItems(){
        cart.clearCart();
   }

   // endregion
//    public Map<CustomerRestaurantMenuItemResponseDTO, Integer>

    // region Order
    public CustomerRestaurantOrdersResponseDTO createOrder(CustomerCreateOrderRequestDTO order){
        GlobalUtil.ifCartEmpty(cart);

        RestaurantOrders newOrder =  RestaurantOrders.builder()
                .restaurantId(1l)
                .orderTime(Instant.now())
                .diningOption(order.getDiningOption())
                .paymentMethod(order.getPaymentMethod())
                .orderStatus(OrderStatus.RECEIVED)
                .table(TableEnum.TABLE_1)
                .totalTax(cart.getTotalTax())
                .totalPrice(cart.getTotalPrice())
                .build();

       cart.getOrders().values().stream().forEach(i-> {


                            RestaurantMenuItem item = restaurantMenuItemRepository.findById(i.getCustomerRestaurantMenuItemResponseDTO().getId()).get();
                            RestaurantOrderMenuItem orderMenuItem = RestaurantOrderMenuItem.builder()
                                    .itemTotal(i.getCartItemTotalPrice())
                                    .itemTaxTotal(i.getCartItemTotalTax())
                                    .quantity(i.getQuantity())
                                    .menuItem(item)
                                    .build();

                            orderMenuItem.setOrder(newOrder);

                        }
                );

        restaurantOrdersRepository.save(newOrder);

        cart.clearCart();



        return MapperUtil.convertRestaurantOrdersToCustomerRestaurantOrdersResponseDTO(newOrder);
    }

    public void  cancelOrder(Long id){
        Optional<RestaurantOrders> order = restaurantOrdersRepository.findById(id);
        GlobalUtil.ifOrderExists(order);
        RestaurantOrders orderReal = order.get();
        GlobalUtil.ifOrderCancellable(orderReal);
        restaurantOrdersRepository.delete(orderReal);
    }




    //endregion



}
