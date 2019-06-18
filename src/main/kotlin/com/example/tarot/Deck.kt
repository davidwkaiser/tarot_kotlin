package com.example.tarot


class Deck(val cards: List<Card>) {

    fun pickCard(): Card {

        return cards.shuffled().first()
    }
}

