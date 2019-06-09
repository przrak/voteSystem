package ru.graduation.votesystem.repository;

import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    Vote save(Vote vote);

    List<Menu> getAllByDate(LocalDate date);
}
