/*
 * 
 */
package userInterface;

import game.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Andrew
 */
public class GUI extends JFrame {
    private GameButton[][] jButtonGrid;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JList jList1;
    private JList jList2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTextArea jTextArea1;
    private GameManager gm;
    private boolean moveSelect;
    private boolean abilitySelect;
    private Ability selectedAbility;
    
    /**
     * Creates new form UserInterface
     */
    public GUI() {
        initComponents();
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")                     
    private void initComponents() {
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jButtonGrid = new GameButton[6][6];
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jList2 = new JList();
        jPanel4 = new JPanel();
        jLabel3 = new JLabel();
        jScrollPane3 = new JScrollPane();
        jTextArea1 = new JTextArea();
        gm = new GameManager();
        moveSelect = false;
        abilitySelect = false;
        selectedAbility = null;
        

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setFocusCycleRoot(false);
        setResizable(false);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        updateTurnOrder();
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Turn Order");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new GridLayout(6,6));
        for (int y=0; y<6; y++)
        {
            for (int x=0; x<6; x++)
            {
                //Tile tile = new Tile(x,y,true);
                //jButtonGrid[x][y] = new GameButton(tile);
                jButtonGrid[x][y] = new GameButton(gm.getField()[x][y]); //Will use the GameManager to populate the tiles.
                jButtonGrid[x][y].setToolTipText("("+x+","+y+")");
                jButtonGrid[x][y].setAlignmentX(0.5F);
                jButtonGrid[x][y].setBorder(null);
                jButtonGrid[x][y].setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                jButtonGrid[x][y].setMargin(new java.awt.Insets(2, 2, 2, 2));
                jButtonGrid[x][y].setMaximumSize(new Dimension(60, 60));
                jButtonGrid[x][y].setMinimumSize(new Dimension(60, 60));
                jButtonGrid[x][y].addActionListener(jButtonGrid[x][y]);
                jPanel2.add(jButtonGrid[x][y]);
            }
        }

        jPanel3.setBorder(BorderFactory.createEtchedBorder());

        jLabel2.setText("Action List");

        updateAbilityList();
        jList2.addListSelectionListener(new ListSelectionListener() {
            public void actionPerformed(ActionEvent evt) {
                jList2ActionPerformed(evt);
            }

            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateAbilityList();
            }
        });
        
        jScrollPane2.setViewportView(jList2);
        
        jButton1.setText("Move");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jButton2.setText("Use Ability");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jButton4.setText("End Turn");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        jButton3.setText("Start Game");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jPanel4.setBorder(BorderFactory.createEtchedBorder());

        jLabel3.setText("Unit Info");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName(""); // NOI18N
        jScrollPane3.setViewportView(jTextArea1);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }
    
    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        //System.out.println("ButtonPress");
        if(jButton1.getText().equals("Move") && !gm.getCurrUnit().isMoved())
        {
            gm.moveRange(true);
            moveSelect = true;
            jButton1.setText("Cancel");
            jButton2.setEnabled(false);
            jButton4.setEnabled(false);
        }
        else if(jButton1.getText().equals("Cancel"))
        {
            gm.moveRange(false);
            moveSelect = false;
            jButton1.setText("Move");
            jButton2.setEnabled(true);
            jButton4.setEnabled(true);
        }
        updateButtons();    
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) 
    {                                         
        if(jButton2.getText().equals("Use Ability") && !gm.getCurrUnit().isAbilitied() && selectedAbility!=null)
        {
            jList2.setEnabled(false);
            gm.showAbilityRange(selectedAbility, true);
            abilitySelect = true;
            jButton2.setText("Cancel");
            jButton1.setEnabled(false);
            jButton4.setEnabled(false);
        }
        else if(jButton2.getText().equals("Cancel"))
        {
            gm.moveRange(false);
            abilitySelect = false;
            jList2.setEnabled(true);
            jButton2.setText("Use Ability");
            jButton1.setEnabled(true);
            jButton4.setEnabled(true);
        }
        updateButtons();
    }
    
    private void jButton3ActionPerformed(ActionEvent evt) {
        jButton3.setEnabled(false);
        gm.initGame();
        updateButtons();
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton4.setEnabled(true);
    }
    private void jButton4ActionPerformed(ActionEvent evt) {
        gm.turn();
        updateTurnOrder();
        updateAbilityList();
    }
    
    private void updateButtons()
    {
        for (GameButton[] gb : jButtonGrid)
        {
            for (GameButton gbi : gb)
            {
                gbi.updateTileImage();
            }
        }
    }

    private void jList2ActionPerformed(ActionEvent evt) {
        selectedAbility = (Ability) jList2.getSelectedValue();
    }
    
    private void updateTurnOrder() {
        jList1.setModel(new AbstractListModel() 
        {
            private LinkedList<Unit> unitList = gm.getTurnOrder();
            public int getSize() { return unitList.size(); }
            public Object getElementAt(int i) { return unitList.get(i); }
        });
    }

    private void updateAbilityList() {
        jList2.setModel(new AbstractListModel() {
            ArrayList<Ability> list = gm.getCurrUnit().getAbilityList();
            public int getSize() { return list.size(); }
            public Object getElementAt(int i) { return list.get(i); }
        });
    }
    
    public class GameButton extends JButton implements ActionListener {
        ImageIcon img;
        Tile tile;
        public GameButton(Tile tile) {
            this.tile = tile;
            //this.gm = gm;
            updateTileImage();
        }
    
        public void updateTileImage()
        {
            if(tile.hasUnit())
            {
                img = new ImageIcon(tile.getUnit().getImage());
                setIcon(img);
            }
            else if(tile.isInRange())
            {
                img = new ImageIcon(tile.getRngImg());
                setIcon(img);
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
        public void actionPerformed(ActionEvent evt) 
        {
            if (moveSelect)
            {
                if(tile.isInRange() && !tile.hasUnit())
                {
                    gm.move(tile);
                    moveSelect = false;
                    jButton1.setText("Move");
                    jButton2.setEnabled(true);
                    jButton4.setEnabled(true);
                    updateButtons();
                }
                else
                {
                    //out of range
                }
            }
            else if (abilitySelect && selectedAbility!=null)
            {
                if(tile.isInRange())
                {
                    gm.useAbility(selectedAbility,tile);
                    abilitySelect = false;
                    jList2.setEnabled(true);
                    jButton2.setText("Use Ability");
                    jButton2.setEnabled(true);
                    jButton4.setEnabled(true);
                    updateButtons();
                }
            }
            else
            {
                //Popup out of range.
            }
            System.out.println("Button Pressed!");
            updateButtons();
        }
    }
    /**
     * @param args
     */
    /*public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }*/       
}
