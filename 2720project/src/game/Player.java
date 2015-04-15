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
    
    
    public Player() {
        team = new ArrayList<Unit>();
         
    }
    
    public void addUnit(Unit u)
    {
        team.add(u);
    }
    
    public Unit getUnit(int index)
    {
        return team.get(index);
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
