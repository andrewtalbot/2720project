/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.LinkedList;

/**
 *
 * @author Andrew
 */
public interface GameInitializer {
    
    /**
     * Method to initialize the game.
     * @param playerList list of players
     * @param turnOrder list for managing the turn order
     * @param field grid array of tiles representing the battlefield
     */
    public void initGame(LinkedList<Player> playerList, LinkedList<Unit> turnOrder, Tile[][] field);
    
    /**
     * Method to handle unit selection by players.
     * @param p the player to grant units to
     * @param num the players number
     */
    public void unitSelection(Player p, int num);
}
