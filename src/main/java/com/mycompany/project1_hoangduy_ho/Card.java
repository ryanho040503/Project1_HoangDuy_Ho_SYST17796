/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1_hoangduy_ho;

/**
 *
 * @author macbookairm1
 */
public class Card {
    
    private int rank; // rank 1 - 13 (Ace - King)
    private String suit; // "Hearts", "Diamonds", "Clubs", "Spades"
    private int index; // 0 - 51 unique index
    
    public Card(int rank, String suit, int index){
        this.rank = rank;
        this.suit = suit;
        this.index = index;
    }
       
    public int getRank(){
        return this.rank;
    }
    
    public String getSuit(){
        return this.suit;
    }
    
    public int getIndex(){
        return this.index;
    }
    
    @Override
    public String toString() {
        return "(" + index + ") " + rank + " " + suit;
    }
}
