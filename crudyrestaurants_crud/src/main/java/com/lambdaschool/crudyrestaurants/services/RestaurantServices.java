package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;

import java.util.List;

/**
 * The Service that works with the Restaurant Model.
 */
public interface RestaurantServices
{    /**
 * Returns a list of all the restaurants.
 *
 * @return List of Restaurant. If no Restaurant, empty list.
 */
List<Restaurant> findAllRestaurants();

    /**
     * Returns the restaurant with the given primary key.
     *
     * @param id The primary key (long) of the restaurant you seek.
     * @return The given Restaurant or throws an exception if not found.
     */
    Restaurant findRestaurantById(long id);

    /**
     * Returns the restaurant with the given name
     *
     * @param name The full name (String) of the Restaurant you seek.
     * @return The Restaurant with the given name or throws an exception if not found.
     */
    Restaurant findRestaurantByName(String name);

    /**
     * A list of all restaurants in a given state.
     *
     * @param state The two character (String) abbreviation of the state you seek.
     * @return List of Restaurant from that state. If no matching Restaurant, empty list.
     */
    List<Restaurant> findByState(String state);

    /**
     * A list of all restaurants whose name contains the given substring.
     *
     * @param thename The substring (String) of name you wish to search for.
     * @return A list of all restaurants whose name contains the given substring. If no matching Restaurant, empty list.
     */
    List<Restaurant> findByNameLike(String thename);

    /**
     * A list of all restaurants whose menu contains the given dish
     *
     * @param thedish The substring (String) of the dish you seek
     * @return A list of all restaurants whose menu contains the given substring. If no matching Restaurant, empty list.
     */
    List<Restaurant> findByDish(String thedish);

    /**
     * A list of all restaurants with their number of menus items
     *
     * @return A list of all restaurants with their number of menus items.
     */
    List<MenuCounts> getMenuCounts();

    /****************************************
     * New to crud
     ****************************************/

    /**
     * Deletes the restaurant record and its menu items from the database based off of the provided primary key
     *
     * @param id id The primary key (long) of the restaurant you seek.
     */
    void delete(long id);

    /**
     * Updates the provided fields in the restaurant record referenced by the primary key.
     * <p>
     * Regarding Payment and Menu items, this process only allows adding those. Deleting and editing those lists
     * is done through a separate endpoint.
     *
     * @param restaurant just the restaurant fields to be updated.
     * @param id         The primary key (long) of the restaurant to update
     * @return the complete restaurant object that got updated
     */
    Restaurant update(
            Restaurant restaurant,
            long id);

    /**
     * Given a complete restaurant object, saves that restaurant object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     *
     * @param restaurant the restaurant object to be saved
     * @return the saved restaurant object including any automatically generated fields
     */
    Restaurant save(Restaurant restaurant);

    /**
     * Deletes are records
     */
    void deleteAllRestaurants();
}
