package ru.graduation.votesystem.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.graduation.votesystem.model.Dish;

public interface CrudDishRepository extends JpaRepository<Dish, Integer> {
}
