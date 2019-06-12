package ru.graduation.votesystem.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.model.Vote;
import ru.graduation.votesystem.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    @Autowired
    private CrudVoteRepository crudRepository;

    @Override
    public Vote save(Vote vote) {
        return null;
    }

    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        return crudRepository.getAllByDate(date);
    }
}
