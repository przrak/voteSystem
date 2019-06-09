package ru.graduation.votesystem.to;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class MenuTo extends BaseTo {

    LocalDate date;

    String restrauntName;

    List<DishTo> dishes;

    public MenuTo(Integer id, LocalDate date, String restrauntName, List<DishTo> dishes) {
        super(id);
        this.date = date;
        this.restrauntName = restrauntName;
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

    public String getRestrauntName() {
        return restrauntName;
    }

    public void setRestrauntName(String restrauntName) {
        this.restrauntName = restrauntName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuTo menuTo = (MenuTo) o;
        return date.equals(menuTo.date) &&
                restrauntName.equals(menuTo.restrauntName) &&
                dishes.equals(menuTo.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, restrauntName, dishes);
    }
}
