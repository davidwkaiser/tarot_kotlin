package com.example.tarot.models


class Deck(val cards: List<Card>) {

    fun pickCard(): Card {

        return cards.shuffled().first()
    }
}

