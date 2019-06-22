package com.example.tarot

import com.example.tarot.models.Deck
import com.example.tarot.models.Response
import org.springframework.stereotype.Service

@Service
class DeckService(private val deck: Deck) {
    fun getCard(): Response {

        return deck.pickCard().let{ it ->
            Response(
                    card = it,
                    orientation = true
            )
        }

    }
}