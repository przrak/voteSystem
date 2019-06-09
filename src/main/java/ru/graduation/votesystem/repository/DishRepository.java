package ru.graduation.votesystem.repository;

import ru.graduation.votesystem.model.Dish;

public interface DishRepository {
    Dish save(Dish dish);

    // false if not found
    boolean delete(int id);
}
