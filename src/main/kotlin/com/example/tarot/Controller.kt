package com.example.tarot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller (val deckService: DeckService ) {


    @GetMapping("/", produces = ["application/json"])
    fun showCard(): String {
        return deckService.getCard().let {
            "Your card is ${it.name}. \n" +
                    "Your keywords are ${it.keywords}"
        }
    }
}