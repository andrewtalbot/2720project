/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Travis
 */
public class Player {
    
    private ArrayList<Unit> team;
    
    
    public Player(Tile[][] field) {
        //build team (instantiate new units of type specified by user)
            
         
    }
    
    public void turn(){
        team.stream().map((unit) -> {
            unit.move();
            return unit;
        }).forEach((unit) -> {
            unit.useAbility();
        });
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
