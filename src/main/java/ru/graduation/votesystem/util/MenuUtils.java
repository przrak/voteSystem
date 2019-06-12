package ru.graduation.votesystem.util;

import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.to.DishTo;
import ru.graduation.votesystem.to.MenuTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuUtils {
    private MenuUtils() {
    }

    public static List<MenuTo> asToList(List<Menu> menus) {
        System.out.println(menus);

        List<MenuTo> menuTos = new ArrayList<>();

        Map<String, List<DishTo>> mapDish = new HashMap<>();

        menus.forEach(
                e -> {
                    List<DishTo> dishesTo;
                    if (mapDish.containsKey(e.getRestaurant().getName())) {
                        dishesTo = mapDish.get(e.getRestaurant().getName());
                    } else {
                        dishesTo = new ArrayList<>();
                        menuTos.add(new MenuTo(e.getRestaurant().getId(), e.getDate(),
                                e.getRestaurant().getName(), null));
                    }
                    dishesTo.add(new DishTo(e.getDish().getId(), e.getDish().getName(),
                            e.getDish().getPrice()));
                    mapDish.put(e.getRestaurant().getName(), dishesTo);
                }
        );

        for (MenuTo menuTo : menuTos) {
            menuTo.setDishes(mapDish.get(menuTo.getName()));
        }

        return menuTos;
    }
}
