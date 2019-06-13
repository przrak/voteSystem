package ru.graduation.votesystem.repository;

import ru.graduation.votesystem.model.Restaurant;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    void delete(int id);

    Restaurant getOne(int id);
}
