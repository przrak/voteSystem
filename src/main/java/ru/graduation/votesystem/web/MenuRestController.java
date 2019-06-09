package ru.graduation.votesystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.graduation.votesystem.repository.MenuRepository;
import ru.graduation.votesystem.to.MenuTo;
import ru.graduation.votesystem.util.MenuUtils;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController {
    static final String REST_URL = "/rest/menus";

    @Autowired
    private MenuRepository repository;

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Menu> get() {
//        return repository.getAll();
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuTo> getByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return MenuUtils.asToList(repository.getAllByDate(date));
    }

}
