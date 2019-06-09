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

    public static List<MenuTo> asToList(List<Menu> menu) {
        System.out.println(menu);

        List<MenuTo> menuTos = new ArrayList<>();

        Map<String, List<DishTo>> mapDish = new HashMap<>();

        menu.forEach(
                e -> {
                    List<DishTo> dto;
                    if (mapDish.containsKey(e.getRestaurant().getName())) {
                        dto = mapDish.get(e.getRestaurant().getName());
                    } else {
                        dto = new ArrayList<>();
                        menuTos.add(new MenuTo(e.getRestaurant().getId(), e.getDate(),
                                e.getRestaurant().getName(), null));
                    }
                    dto.add(new DishTo(e.getDish().getId(), e.getDish().getName(),
                            e.getDish().getPrice()));
                    mapDish.put(e.getRestaurant().getName(), dto);
                }
        );

        for (MenuTo menuTo : menuTos) {
            menuTo.setDishes(mapDish.get(menuTo.getRestrauntName()));
        }

        return menuTos;
    }
}
