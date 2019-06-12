package ru.graduation.votesystem.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.graduation.votesystem.model.Restaurant;
import ru.graduation.votesystem.repository.RestaurantRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    @Override
    public Restaurant save(Restaurant restaurant) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
