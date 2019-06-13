package ru.graduation.votesystem.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.graduation.votesystem.model.Dish;
import ru.graduation.votesystem.repository.DishRepository;

import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    private CrudDishRepository crudRepository;

    @Override
    public Dish save(Dish dish) {
        return crudRepository.save(dish);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Dish get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> getAll() {
        return crudRepository.findAll();
    }


}
