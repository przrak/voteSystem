package ru.graduation.votesystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.graduation.votesystem.repository.MenuRepository;
import ru.graduation.votesystem.to.MenuTo;
import ru.graduation.votesystem.util.MenuUtils;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MenuRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuRepository repository;

    @GetMapping(value = "/rest/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuTo> getByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getMenuByDate {}", date);
        return MenuUtils.asToList(repository.getAllByDate(date));
    }

    @DeleteMapping("/rest/admin/menus/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        repository.delete(id);
    }
}
