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
public class BaseInitializer implements GameInitializer{
    
    @Override
    public void initGame(LinkedList<Player> playerList, LinkedList<Unit> turnOrder, Tile[][] field)
    {
        playerList.clear();
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        playerList.add(p1);
        playerList.add(p2);
        unitSelection(p1, 1);
        field[0][0].setUnit(p1.getUnit(0));
        p1.getUnit(0).setPos(0, 0);
        p1.getUnit(0).setImage("res/Archer-purple.png");
        field[1][3].setUnit(p1.getUnit(1));
        p1.getUnit(1).setPos(1, 3);
        p1.getUnit(1).setImage("res/Warrior-purple.png");
        field[1][2].setUnit(p1.getUnit(2));
        p1.getUnit(2).setPos(1, 2);
        p1.getUnit(2).setImage("res/Warrior-purple.png");
        field[0][5].setUnit(p1.getUnit(3));
        p1.getUnit(3).setPos(0, 5);
        p1.getUnit(3).setImage("res/Wizard-purple.png");
        unitSelection(p2, 2);
        field[5][5].setUnit(p2.getUnit(0));
        p2.getUnit(0).setPos(5, 5);
        p2.getUnit(0).setImage("res/Archer-green.png");
        field[4][3].setUnit(p2.getUnit(1));
        p2.getUnit(1).setPos(4, 3);
        p2.getUnit(1).setImage("res/Warrior-green.png");
        field[4][2].setUnit(p2.getUnit(2));
        p2.getUnit(2).setPos(4, 2);
        p2.getUnit(2).setImage("res/Warrior-green.png");
        field[5][0].setUnit(p2.getUnit(3));
        p2.getUnit(3).setPos(5, 0);
        p2.getUnit(3).setImage("res/Wizard-green.png");
        for (int i = 0; i < 4; i++) {
            turnOrder.add(p1.getUnit(i));
            turnOrder.add(p2.getUnit(i));
        }
    }
    
    @Override
    public void unitSelection(Player p, int num)
    {
        Unit archer = new Archer(num);
        p.addUnit((Unit) archer);
        Unit warrior1 = new Warrior(num);
        p.addUnit((Unit) warrior1);
        Unit warrior2 = new Warrior(num);
        p.addUnit((Unit) warrior2);
        Unit wizard = new Wizard(num);
        p.addUnit((Unit) wizard);
    }
}
