package ru.graduation.votesystem.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.graduation.votesystem.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote user);

    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user LEFT JOIN FETCH v.restaurant WHERE v.date=?1")
    List<Vote> getAllByDate(LocalDate date);

    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user LEFT JOIN FETCH v.restaurant WHERE v.date=?1 AND v.user.id=?2")
    Vote getByUserIdAndDate(LocalDate date, int userId);
}
