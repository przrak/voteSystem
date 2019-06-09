package ru.graduation.votesystem.repository;

import ru.graduation.votesystem.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository {

    List<Menu> getAll();

    List<Menu> getAllByDate(LocalDate date);

}
