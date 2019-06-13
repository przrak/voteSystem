package ru.graduation.votesystem.repository;

import ru.graduation.votesystem.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish save(Dish dish);

    void delete(int id);

    Dish get(int id);

    List<Dish> getAll();
}
