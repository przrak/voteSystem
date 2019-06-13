package ru.graduation.votesystem.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.repository.MenuRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.graduation.votesystem.util.ValidationUtil.checkNotFoundWithDate;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudRepository;

    @CacheEvict(value = "menus", allEntries = true)
    @Override
    public Menu save(Menu menu) {
        return null;
    }

    @CacheEvict(value = "menus", allEntries = true)
    @Override
    public boolean delete(int id) {
        return false;
    }

    @Cacheable("menus")
    @Override
    public List<Menu> getAllByDate(LocalDate date) {
        return checkNotFoundWithDate(crudRepository.getAllByDate(date), date);
    }
}
