package com.lambdaschool.crudyrestaurants.services;

/*
 * Note: "Unless there's some extra information that isn't clear from the interface description (there rarely is), the implementation documentation should then simply link to the interface method."
 * Taken from https://stackoverflow.com/questions/11671989/best-practice-for-javadocs-interface-implementation-or-both?lq=1
 */

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the RestaurantService Interface.
 */
@Transactional
@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
    /**
     * Connects this service to the Restaurant Table.
     */
    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public Restaurant save(Restaurant restaurant)
    {
        return restrepos.save(restaurant);
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();
            restrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);

            return list;
    }

    @Override
    public Restaurant findById(long id) {
        return restrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + id + " does not exist"));
    }

    @Override
    public Restaurant findByName(String name) {
        Restaurant r = restrepos.findByNameIgnoringCase(name);
        if (r == null) {
            throw new EntityNotFoundException(("Restaurant " + name + " not found"));
        }

        return r;
    }

    @Override
    public List<Restaurant> findByNameLike(String subname) {
        List<Restaurant> r = restrepos.findByNameContainingIgnoringCase(subname);

        if (r == null) {
            throw new EntityNotFoundException(("Restaurant containing the name " + subname + " not found"));
        }

        return r;
    }

    @Override
    public List<MenuCounts> getMenuCounts() {
        return restrepos.getMenuCounts();
    }

    @Override
    public List<Restaurant> findByDish(String dish) {
        return restrepos.findByMenus_dishContainingIgnoringCase(dish);
    }
}
