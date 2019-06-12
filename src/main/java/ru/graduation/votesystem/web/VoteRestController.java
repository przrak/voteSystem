package ru.graduation.votesystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.graduation.votesystem.model.Vote;
import ru.graduation.votesystem.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/votes";

    @Autowired
    private VoteRepository repository;

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> createWithLocation(@RequestBody User user) {
//        User created = super.create(user);
//        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path(REST_URL + "/{id}")
//                .buildAndExpand(created.getId()).toUri();
//        return ResponseEntity.created(uriOfNewResource).body(created);
//
//        /*
//            передать
//            user_id
//            restraunt_id
//            date
//         */
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return repository.getAllByDate(date);
    }
}
