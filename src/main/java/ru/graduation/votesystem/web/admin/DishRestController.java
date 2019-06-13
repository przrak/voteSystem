package ru.graduation.votesystem.web.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.graduation.votesystem.model.Dish;
import ru.graduation.votesystem.repository.DishRepository;
import ru.graduation.votesystem.util.exception.IllegalRequestDataException;

import java.util.List;

@RestController
@RequestMapping(value = DishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController {
    static final String REST_URL = "/rest/admin/dishes";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll() {
        log.info("getAll for dishes");
        List<Dish> dishes = repository.getAll();
        if (dishes.isEmpty())
            throw new IllegalRequestDataException("Dishes dictionary is empty");

        return dishes;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable int id) {
        log.info("get dish {}", id);
        Dish dish = repository.get(id);
        if (dish == null)
            throw new IllegalRequestDataException("Dish not found");

        return dish;
    }
}
