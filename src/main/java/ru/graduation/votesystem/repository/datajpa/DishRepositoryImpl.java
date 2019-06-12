package ru.graduation.votesystem.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.graduation.votesystem.model.Dish;
import ru.graduation.votesystem.repository.DishRepository;

@Repository
public class DishRepositoryImpl implements DishRepository {
    @Override
    public Dish save(Dish dish) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
