package ru.firesin.entry.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class EntryController {
    @PostMapping("/entry")
    public String entry() {
        return "Follow to the white Rabbit. Knock, knock...";
    }
}
