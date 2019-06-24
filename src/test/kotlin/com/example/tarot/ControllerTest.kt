package com.example.tarot

import com.example.tarot.models.Card
import com.example.tarot.models.Response
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
internal class ControllerTest {

    val mockService = mock<DeckService>()

    val testCard = Card("name", "image", listOf("word1", "word2"))

    val response1 = Response(testCard, false)
    val response2 = Response(testCard, true)

    val subject = Controller(mockService)

    @Before
    fun setUp(){
        whenever(mockService.getCard()).thenReturn(response1)
    }

    @Test
    fun `showCard calls the deckService`(){

        subject.showCard().let{
            verify(mockService).getCard()
        }
    }

    @Test
    fun `showCard returns nice standard text`(){

        val expectedOutput = "Your card is name. \n" +
                "Your keywords are [word1, word2]"

        subject.showCard().let{
            assertThat(it).isEqualTo(expectedOutput)
        }
    }

    @Test
    fun `showCard returns nice inverted text`(){

        whenever(mockService.getCard()).thenReturn(response2)

        val expectedOutput = "Your card is name, inverted. \n" +
                "Your keywords are [word1, word2]"

        subject.showCard().let{
            assertThat(it).isEqualTo(expectedOutput)
        }
    }
}

