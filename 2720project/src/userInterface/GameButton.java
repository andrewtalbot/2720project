/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import game.Tile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Andrew
 */
public class GameButton extends JButton implements ActionListener {
    ImageIcon img;
    Tile tile;
    public GameButton(Tile tile) {
        this.tile = tile;
        updateTileImage();
    }
    
    final public void updateTileImage()
    {
        if(tile.hasUnit())
        {
            img = new ImageIcon(tile.getUnit().getImage());
        }
        else if(tile.isTraversable())
        {
            img = new ImageIcon(tile.getImage());
            setIcon(img);
        }
        else
        {
            img = new ImageIcon(tile.getImage());
            setIcon(img);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {                                         
        updateTileImage();
    }
    
}
