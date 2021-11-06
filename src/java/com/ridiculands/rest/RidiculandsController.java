package com.ridiculands.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RidiculandsController {

    List<String> games = new ArrayList<>(Arrays.asList(
            "Spongebob Squarepants - Battle for Bikini Bottom",
            "Kirby Star Allies",
            "Dragon Ball Z"));

    @GetMapping(value="/games", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<String> listGames() {
        return games;
    }

    @GetMapping(value="/games/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String retrieveGameById(@PathVariable Integer id) {
        if (id > -1 && id < games.size()) {
            return games.get(id);
        } else {
            return "cannot find game with ID=" + id;
        }
    }
}
