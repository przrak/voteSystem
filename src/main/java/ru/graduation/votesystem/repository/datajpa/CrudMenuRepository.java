package ru.graduation.votesystem.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.graduation.votesystem.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {
    
    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.dish LEFT JOIN FETCH m.restaurant WHERE m.date=?1")
    List<Menu> getAllByDate(@Param("date") LocalDate date);
}
