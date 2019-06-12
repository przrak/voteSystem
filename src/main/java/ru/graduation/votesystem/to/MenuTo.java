package ru.graduation.votesystem.to;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class MenuTo extends NamedTo {

    private LocalDate date;

    private List<DishTo> dishes;

    public MenuTo(Integer id, LocalDate date, String restaurantName, List<DishTo> dishes) {
        super(id, restaurantName);
        this.date = date;
        this.dishes = dishes;
    }

    public List<DishTo> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishTo> dishes) {
        this.dishes = dishes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuTo menuTo = (MenuTo) o;
        return date.equals(menuTo.date) &&
                name.equals(menuTo.name) &&
                dishes.equals(menuTo.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name, dishes);
    }
}
