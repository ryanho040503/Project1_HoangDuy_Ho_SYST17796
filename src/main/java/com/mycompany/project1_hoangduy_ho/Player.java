/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1_hoangduy_ho;

/**
 *
 * @author macbookairm1
 */

import java.util.ArrayList;
import java.util.List;

public class Player 
{
   
    private String name;
    private int position;
    private List<Card> hand;
    private int score;

    // Constructor
    public Player(String name, int position) 
    {
        this.name = name;
        this.position = position;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() 
    {
        return name;
    }

    public List<Card> getHand() 
    {
        return hand;
    }

    public void addCard(Card card) 
    {
        hand.add(card);
    }
    
    public void drawCard(Deck deck) 
    {
//      We have to draw card from the deck to minus number of card(s)
        Card drawn = deck.draw();
        if (drawn != null) {
//          Adding the drawn card into the hand of player
            hand.add(drawn);
            System.out.println(this.name + " drew: " + drawn);
        }
    }
    
    // Try to match the top card by suit or rank
    public Card matchCard(Card topCard) 
    {
        for (Card card : hand) 
        {
            if (card.getSuit().equals(topCard.getSuit()) || card.getRank() == topCard.getRank()) 
            {
                // Remove the card from hand if match
                hand.remove(card);
                System.out.println(name + " played: " + card);
                return card;
            }
        }
        return null;
    }
    
    
    // Full turn: try to play, otherwise draw up to 3 times
    public void turn(Deck deck, Card topCard) {
        Card played = matchCard(topCard);
        if (played != null) {
            deck.setTopCard(played);
        } else {
            for (int i = 0; i < 3 && played == null; i++) {
                drawCard(deck);
                played = matchCard(deck.getTopCard());
                if (played != null) {
                    deck.setTopCard(played);
                    break;
                }
            }
            if (played == null) {
                System.out.println(name + " has no playable card after 3 draws.\n");
            }
        }
    }
    
    public boolean hasNoCards() 
    {
        return hand.isEmpty();
    }

//  Show hand on the console
    public void showHand() 
    {
        System.out.println(name + ":");
        for (Card c : hand) 
        {
            System.out.println("  " + c);
        }
        System.out.println();
    }
}
