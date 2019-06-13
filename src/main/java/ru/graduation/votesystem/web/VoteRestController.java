package ru.graduation.votesystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.graduation.votesystem.model.Vote;
import ru.graduation.votesystem.service.VoteService;
import ru.graduation.votesystem.to.BaseTo;
import ru.graduation.votesystem.to.VoteTo;
import ru.graduation.votesystem.util.VoteUtils;
import ru.graduation.votesystem.util.exception.IllegalRequestDataException;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.graduation.votesystem.util.ValidationUtil.checkNew;
import static ru.graduation.votesystem.web.SecurityUtil.authUserId;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/votes";
    private static final LocalTime time = LocalTime.of(11, 0);

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> createWithLocation(@RequestBody BaseTo baseTo) {

        //Чтобы можно было создавать\изменять голос ТОЛЬКО на текущую дату, не передаю ее в параметре
        LocalDate date = LocalDate.now();
        Vote vote;

        if (voteService.getByUserIdAndDate(date, authUserId()) != null)
        {
            if (LocalTime.now().isBefore(time))
            {
                log.info("update vote for restaurant {}", baseTo.getId());
                vote = voteService.update(baseTo, authUserId(), date);
            }
            else
            {
                throw new IllegalRequestDataException("It is too late, vote can't be changed");
            }
        }
        else
        {
            //create
            log.info("create new vote for restaurant {}", baseTo.getId());
            vote = voteService.create(baseTo, authUserId(), date);
        }

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(vote.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(vote);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VoteTo> getByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getVoteByDate {}", date);
        List<VoteTo> votes = VoteUtils.asToList(voteService.getAllByDate(date));
        if (votes.isEmpty())
            throw new IllegalRequestDataException("No vote data for today");

        return votes;
    }
}
