package com.example.tarot

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
internal class ControllerTest {

    val mockService = mock<DeckService>()

    val testCard = Card("name", "image", listOf("word") )

    val subject = Controller(mockService)

    @Before
    fun setUp(){
        whenever(mockService.getCard()).thenReturn(testCard)
    }

    @Test
    fun `showCard calls the deckService`(){

        subject.showCard().let{
            verify(mockService).getCard()
            assertThat(it.name).isEqualTo("name")
        }
    }
}

