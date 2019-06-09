package ru.graduation.votesystem.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.repository.MenuRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaMenuRepositoryImpl implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudRepository;
    
    @Override
    public List<Menu> getAll() {
        return crudRepository.getAll();
    }

    @Override
    public List<Menu> getAllByDate(LocalDate date) {
        return crudRepository.getAllByDate(date);
    }
}
