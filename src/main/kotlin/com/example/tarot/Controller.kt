package com.example.tarot

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

//@RestController
@Controller
class Controller (val deckService: DeckService ) {


    @GetMapping("/")
    fun showCard(model : Model): String {

        model.addAttribute("response", deckService.getCard() )
        return "index"
    }
}