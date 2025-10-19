/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1_hoangduy_ho;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author macbookairm1
 */
public class Deck 
{
    
    private int numCards;
    private List<Card> cards;
    private Card topCard;
    private boolean empty;

    public Deck()
    {
        cards = new ArrayList<>();
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        int index = 0;
        
        for (String suit : suits) 
        {
            for (int rank = 1; rank <= 13; rank++) 
            {
                cards.add(new Card(rank, suit, index++));
            }
        }
        numCards = cards.size();
        empty = false;
    }
    
    // Shuffle cards manually
    public void shuffle() 
    {
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) 
        {
            int j = rand.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }
    
     // Draw top card
    public Card draw() 
    {
        if (cards.isEmpty()) 
        {
            empty = true;
            return null;
        }
        numCards--;
        return cards.remove(0);
    }

    public void setTopCard(Card card) 
    {
        this.topCard = card;
    }

    public Card getTopCard() 
    {
        return topCard;
    }

    public boolean isEmpty() 
    {
        return cards.isEmpty();
    }
}
