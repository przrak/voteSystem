package ru.graduation.votesystem.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote user);


    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user LEFT JOIN FETCH v.restaurant WHERE v.date=?1")
    List<Vote> getAllByDate(@Param("date") LocalDate date);
}
