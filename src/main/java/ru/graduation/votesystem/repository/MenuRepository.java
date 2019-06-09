package ru.graduation.votesystem.repository;

import ru.graduation.votesystem.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository {


    Menu save(Menu menu);

    // false if not found
    boolean delete(int id);


    List<Menu> getAllByDate(LocalDate date);

}
