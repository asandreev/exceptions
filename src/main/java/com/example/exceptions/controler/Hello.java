package com.example.exceptions.controler;

import com.example.exceptions.dto.Genre;
import com.example.exceptions.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Hello {
    private static final String template = "Hello, %s %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello/{genre}")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @PathVariable(value = "genre") Genre genre
    ) {
        return new Greeting(counter.incrementAndGet(), String.format(template, genre.getLabel(), name));
    }

}
