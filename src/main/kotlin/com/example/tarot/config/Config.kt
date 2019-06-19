package com.example.tarot.config

import com.example.tarot.Deck
import com.example.tarot.WaiteSmithDeck
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config{

    @Bean
    fun deck(): Deck{
        return Deck(cards = WaiteSmithDeck.cards)
    }



}