/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Travis Class which contains the details of a player.
 */
public class Player {

    private ArrayList<Unit> team;
    private int player;

    /**
     * Constructor which initializes a player.
     * @param pl the player number.
     */
    public Player(int pl) {
        team = new ArrayList<Unit>();
        player = pl;
    }

    /**
     * Method to get the player number.
     * @return an int containing the player number
     */
    public int getPlayer() {
        return player;
    }

    /**
     * Method to get the team of units a player commands.
     * @return the list of units.
     */
    public ArrayList<Unit> getTeam() {
        return team;
    }

    /**
     * Method to set the team of units a player commands.
     * @param unitList 
     */
    public void setTeam(ArrayList<Unit> unitList) {
        this.team = unitList;
    }

    /**
     * Method to add a unit to the team of units a player commands.
     * @param u unit to be added.
     */
    public void addUnit(Unit u) {
        team.add(u);
    }

    /**
     * Method to get a unit within the team based on a given index.
     * @param index
     * @return the unit at index
     */
    public Unit getUnit(int index) {
        return team.get(index);
    }

    /**
     * Method to get the size of the team.
     * @return the size of the team
     */
    public int getSize() {
        return team.size();
    }

    /**
     * Method to remove a unit at a given index.
     * @param index 
     */
    public void killUnit(int index) {
        team.remove(index);
    }
    
    /**
     * Method to check if a player has lost by losing all his units.
     * @return true if a players team is empty.
     */
    public boolean lose() {
        if (team.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
