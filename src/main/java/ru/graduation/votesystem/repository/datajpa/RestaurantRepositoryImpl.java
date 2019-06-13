package ru.graduation.votesystem.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import ru.graduation.votesystem.model.Restaurant;
import ru.graduation.votesystem.repository.RestaurantRepository;

import static ru.graduation.votesystem.util.ValidationUtil.checkNotFoundWithId;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository crudRepository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        Assert.notNull(restaurant, "dish must not be null");
        return crudRepository.save(restaurant);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(crudRepository.delete(id) != 0, id);
    }

    public Restaurant getOne(int id)
    {
        return crudRepository.getOne(id);
    }
}
