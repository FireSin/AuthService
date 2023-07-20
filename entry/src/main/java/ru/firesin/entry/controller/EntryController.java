package ru.firesin.entry.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.firesin.my_annotations.secured.MySecured;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class EntryController {

    @PostMapping("/entry")
    @MySecured("localUser")
    public String entry(HttpServletRequest request) {
        return "Follow to the white Rabbit. Knock, knock...";
    }
}
