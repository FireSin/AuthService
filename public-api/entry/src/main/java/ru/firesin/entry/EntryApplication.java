package ru.firesin.entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.firesin.entry")
public class EntryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntryApplication.class, args);
    }

}
