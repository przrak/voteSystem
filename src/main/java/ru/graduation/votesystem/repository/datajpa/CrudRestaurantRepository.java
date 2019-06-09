package ru.graduation.votesystem.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.graduation.votesystem.model.Restaurant;

public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
