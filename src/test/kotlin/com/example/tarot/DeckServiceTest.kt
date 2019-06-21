package com.example.tarot

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test



internal class DeckServiceTest{

    val deck1  = mock<Deck>()

    val subject = DeckService(deck1)

    @Test
    fun `getCard calls pickCard method in the Deck`(){

        subject.getCard()
            verify(deck1).pickCard()

    }
}