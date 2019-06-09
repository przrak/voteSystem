package ru.graduation.votesystem.repository;

import ru.graduation.votesystem.model.Vote;

public interface VoteRepository {
    Vote save(Vote vote);
}
