package ru.graduation.votesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.graduation.votesystem.model.Vote;
import ru.graduation.votesystem.repository.RestaurantRepository;
import ru.graduation.votesystem.repository.UserRepository;
import ru.graduation.votesystem.repository.VoteRepository;
import ru.graduation.votesystem.to.BaseTo;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    @CacheEvict(value = "votes", allEntries = true)
    @Override
    public Vote create(BaseTo baseTo, int userId, LocalDate date) {
        Vote vote = new Vote();
        vote.setDate(date);
        vote.setRestaurant(restaurantRepository.getOne(baseTo.getId()));
        vote.setUser(userRepository.getOne(userId));
        return voteRepository.save(vote);
    }

    @CacheEvict(value = "votes", allEntries = true)
    @Override
    public Vote update(BaseTo baseTo, int userId, LocalDate date) {
        Vote vote = voteRepository.getByUserIdAndDate(date, userId);
        vote.setRestaurant(restaurantRepository.getOne(baseTo.getId()));
        return voteRepository.save(vote);
    }

    @Override
    public Vote getByUserIdAndDate(LocalDate date, int userId) {
        return voteRepository.getByUserIdAndDate(date, userId);
    }

    @Cacheable("votes")
    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        return voteRepository.getAllByDate(date);
    }
}
