package kr.co.joy.eatgo.interfaces;

import kr.co.joy.eatgo.domain.MenuItem;
import kr.co.joy.eatgo.domain.MenuItemRepository;
import kr.co.joy.eatgo.domain.Restaurant;
import kr.co.joy.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItem(menuItems);
        return restaurant;
    }
}