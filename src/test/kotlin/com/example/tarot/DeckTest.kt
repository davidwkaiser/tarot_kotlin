package com.example.tarot

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class DeckTest {

    val card1 = Card("The Dork", "dork.jpg", listOf("attribute1", "attribute2"))
    val subject = Deck(cards = listOf(card1))

    @Before
    fun setUp() {
    }

    @Test
    fun `pick a card returns a valid card from the deck`(){
        subject.pickCard().let{ it ->
            assertEquals(it.name, "The Dork")
        }

    }

}