package com.example.tarot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller (val deckService: DeckService ) {


    @GetMapping("/", produces = ["application/json"])
    fun showCard(): String {
        return deckService.getCard().let {
            val ending = if (it.isInverted) ", inverted." else "."
            "Your card is ${it.card.name}${ending} \n" +
                    "Your keywords are ${it.card.keywords}"
        }
    }
}