package ru.graduation.votesystem.repository.datajpa;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudVoteRepository {
}
