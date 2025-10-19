/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1_hoangduy_ho;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbookairm1
 */

public class Game {
    
    
    private List<Player> players;
    private Deck deck;

    // Constructor with 4 players
    public Game() 
    {
        deck = new Deck();
        players = new ArrayList<>();
        players.add(new Player("Hoang Duy", 0));
        players.add(new Player("Jame", 1));
        players.add(new Player("Ash", 2));
        players.add(new Player("Dylan", 3));
    }
    
     // Start the game
    public void start() 
    {
        deck.shuffle();
        dealCards();

        // Flip first card
        Card first = deck.draw();
        deck.setTopCard(first);
        System.out.println("Starting card: " + first + "\n");

        boolean gameOver = false;
        while (!gameOver) 
        {
            for (Player player : players) 
            {
                System.out.println("Top card: " + deck.getTopCard());
                player.turn(deck, deck.getTopCard());

                if (player.hasNoCards()) 
                {
                    System.out.println("********** " + player.getName() + " won ***********");
                    gameOver = true;
                    break;
                }
            }
        }
    }

    // Deal 5 cards to each player
    private void dealCards() 
    {
        for (int i = 0; i < 5; i++) 
        {
            for (Player p : players) 
            {
                p.addCard(deck.draw());
            }
        }

        for (Player p : players) 
        {
            p.showHand();
        }
    }

    // Return the winner (optional for Week 6)
    public Player playerWon() 
    {
        for (Player p : players) 
        {
            if (p.hasNoCards()) 
            {
                return p;
            }
        }
        return null;
    }
}
