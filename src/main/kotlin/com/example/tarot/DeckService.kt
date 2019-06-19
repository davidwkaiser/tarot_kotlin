package com.example.tarot

import org.springframework.stereotype.Service

@Service
class DeckService(private val deck: Deck) {
    fun getCard(): Card {

        return deck.pickCard()

    }
}