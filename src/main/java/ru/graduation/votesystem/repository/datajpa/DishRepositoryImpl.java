package ru.graduation.votesystem.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import ru.graduation.votesystem.model.Dish;
import ru.graduation.votesystem.repository.DishRepository;

import java.util.List;

import static ru.graduation.votesystem.util.ValidationUtil.checkNotFoundWithId;

@Repository
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    private CrudDishRepository crudRepository;

    @Override
    public Dish save(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        return crudRepository.save(dish);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(crudRepository.delete(id) != 0, id);
    }

    @Override
    public Dish get(int id) {
        return checkNotFoundWithId(crudRepository.findById(id).orElse(null), id);
    }

    @Override
    public List<Dish> getAll() {
        return crudRepository.findAll();
    }


}
