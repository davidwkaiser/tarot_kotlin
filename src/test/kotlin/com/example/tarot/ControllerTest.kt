package com.example.tarot

import com.example.tarot.models.Card
import com.example.tarot.models.Response
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.springframework.ui.Model

internal class ControllerTest {

    val mockService = mock<DeckService>()

    val testCard = Card("name", "image", listOf("word1", "word2"))

    val response1 = Response(testCard, false)
    val response2 = Response(testCard, true)

    val subject = Controller(mockService)

    val model = mock<Model>()

    @Before
    fun setUp(){
        whenever(mockService.getCard()).thenReturn(response1)
    }

    @Test
    fun `showCard calls the deckService`(){

        subject.showCard(model).let{
            verify(mockService).getCard()
        }
    }


    @Test
    fun `showCard adds model and returns index`(){

        subject.showCard(model).let{
            assertThat(it).isEqualTo("index")
            verify(model).addAttribute("response", response1)
        }
    }

    @Test
    fun `showCard adds inverted model and returns index`(){

        whenever(mockService.getCard()).thenReturn(response2)

        subject.showCard(model).let{
            assertThat(it).isEqualTo("index")
            verify(model).addAttribute("response", response2)
        }
    }
}

