package ru.graduation.votesystem.service;

import org.springframework.transaction.annotation.Transactional;
import ru.graduation.votesystem.model.Vote;
import ru.graduation.votesystem.to.BaseTo;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface VoteService {

    @Transactional
    Vote create(BaseTo baseTo, int userId, LocalDate date);

    @Transactional
    Vote update(BaseTo baseTo, int userId, LocalDate date);

    Vote getByUserIdAndDate(LocalDate date, int userId);

    List<Vote> getAllByDate(LocalDate date);

}
