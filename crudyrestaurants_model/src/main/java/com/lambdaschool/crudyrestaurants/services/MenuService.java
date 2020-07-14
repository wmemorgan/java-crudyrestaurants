package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findAllMenus();
}
