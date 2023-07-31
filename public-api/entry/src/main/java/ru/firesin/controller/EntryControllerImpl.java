package ru.firesin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.firesin.annotations.secured.MySecured;

@RestController
public class EntryControllerImpl implements EntryController {

    @PostMapping("/entry")
    @MySecured("localUser")
    public String entry() {
        return "Follow to the white Rabbit. Knock, knock...";
    }
}
