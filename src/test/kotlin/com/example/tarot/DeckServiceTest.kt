package com.example.tarot

import com.example.tarot.models.Card
import com.example.tarot.models.Deck
import com.example.tarot.models.Response
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test



internal class DeckServiceTest{

    val card1 = Card("name", "img", listOf("word1"))

    val deck1  = mock<Deck>()

    val subject = DeckService(deck1)

    @Before
    fun setUp(){
        whenever(deck1.pickCard()).thenReturn(card1)
    }

    @Test
    fun `getCard calls pickCard method in the Deck`(){

        subject.getCard()
            verify(deck1).pickCard()
    }

    @Test
    fun `getCard returns a Response object`(){
        subject.getCard().let{
            assertThat(it).isInstanceOf(Response::class.java)
        }
    }

    @Test
    fun `isInverted returns a boolean value`(){

        subject.isInverted().let{
            assertThat(it == true || it == false).isTrue()
        }
    }
}