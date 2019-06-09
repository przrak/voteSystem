package ru.graduation.votesystem.repository.datajpa;

import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.model.Vote;
import ru.graduation.votesystem.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

public class VoteRepositoryImpl implements VoteRepository {

    @Override
    public Vote save(Vote vote) {
        return null;
    }

    @Override
    public List<Menu> getAllByDate(LocalDate date) {
        return null;
    }
}
