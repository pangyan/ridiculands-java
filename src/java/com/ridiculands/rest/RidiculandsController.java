package com.ridiculands.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RidiculandsController {

    List<String> games = new ArrayList<>();

    @GetMapping(value="/games", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<String> listGame() {
        // TODO
        games.add("Spongebob Squarepants - Battle for Bikini Bottom");
        games.add("Kirby Star Allies");
        games.add("Dragon Ball Z");
        // END TODO

        return games;
    }
}
