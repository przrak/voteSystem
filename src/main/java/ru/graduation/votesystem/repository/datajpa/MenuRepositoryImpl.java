package ru.graduation.votesystem.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.repository.MenuRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudRepository;

    @Override
    public Menu save(Menu menu) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Menu> getAllByDate(LocalDate date) {
        return crudRepository.getAllByDate(date);
    }
}
