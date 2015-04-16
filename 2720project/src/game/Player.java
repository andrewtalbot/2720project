/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Travis
 */
public class Player {
    
    private ArrayList<Unit> team;
    private int player;
    
    public Player(int pl) {
        team = new ArrayList<Unit>();
        player = pl; 
    }

    public int getPlayer() {
        return player;
    }
    
    public ArrayList<Unit> getTeam()
    {
        return team;
    }
    
    public void setTeam(ArrayList<Unit> unitList)
    {
        this.team=unitList;
    }
    
    public void addUnit(Unit u)
    {
        team.add(u);
    }
    
    public Unit getUnit(int index)
    {
        return team.get(index);
    }
    
    public int getSize()
    {
        return team.size();
    }
    
    public void killUnit(int index)
    {
        team.remove(index);
    }
    
    public void turn(){
        
    }
    
    public boolean lose() {
        if(team.isEmpty()){ 
            return true;
        }
        else {
            return false;
        }
    }

}
