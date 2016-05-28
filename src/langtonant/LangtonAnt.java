/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package langtonant;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.MatteBorder;


/**
 *
 * @author Aleksandra
 */
public class LangtonAnt {

    public static void main(String[] args) {
        new Window();
    }
}

<<<<<<< Upstream, based on origin/master
class Window {

            
        Window(){

            JFrame frame = new JFrame("Langton Ant");
            
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            final int screenWidth = screenSize.width;       
            final int screenHeight = screenSize.height;                
            frame.setSize(screenWidth, screenHeight);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            
            frame.add(new Panel(), BorderLayout.LINE_START);
            frame.add(new Buttons());

            frame.setVisible(true);
            }

    public class Buttons extends JPanel{

            JButton Start = new JButton("START");
            JButton Stop = new JButton("STOP");
            JButton AddAnt = new JButton("ADD ANT");
            JButton GoTo = new JButton("DO STEPS");
            JTextField Counter = new JTextField(10); 
            JTextField AddSteps = new JTextField(10);
            JLabel StepLabel = new JLabel("STEPS: ");
            
        public Buttons(){
            setLayout(null);
            add(Start);
            add(Stop);
            add(AddAnt);
            add(GoTo);
            add(Counter);
            add(AddSteps);
            add(StepLabel); 
            
        //Przyciski
            Start.setBounds(10, 10, 100, 40);
            Stop.setBounds(10, 60, 100, 40);
        //Licznik kroków
            StepLabel.setBounds(40, 100, 50, 30);                     
            Counter.setBounds(10, 130, 100, 30);
        //Dodawanie mrówki    
            AddAnt.setBounds(10, 170, 100, 40);
            
        //przeskok o liczbę kroków
            AddSteps.setBounds(10, 220, 100, 30);           
            GoTo.setBounds(10, 260, 100, 40);
            
        }
    }
    
    public class Panel extends JPanel {

        public Panel() {
            setLayout(new GridBagLayout());
            
            GridBagConstraints grid = new GridBagConstraints();
            for (int row = 0; row < 60; row++) {
                for (int column = 0; column < 110; column++) {
                    grid.gridx = column;
                    grid.gridy = row;

                    CellPane cellPane = new CellPane();
                    
                    MatteBorder border = null;
                    if (row < 59) {
                        if (column < 109) {
                            border = new MatteBorder(1, 1, 0, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.BLACK);
                        }
                    } else {
                        if (column < 109) {
                            border = new MatteBorder(1, 1, 1, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                        }
                    }
                    cellPane.setBorder(border);
                    add(cellPane, grid);
                }
=======
    }    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            long aSteps;
            long aStepsToJump;
            
            if(e.getSource() == Start){
                //
            }else if(e.getSource() == Stop){
                //
            }else if(e.getSource() == AddingAnt){
                //
            }else if(e.getSource() == GoTo){ //Przeskok o ilość kroków - do wyrysowania na raz jakiejś liczby kroków
                aSteps = Long.parseLong(Counter.getText());    
                aStepsToJump = Long.parseLong(AddingSteps.getText());
                Counter.setText(String.valueOf(aSteps += aStepsToJump));
>>>>>>> 07d3c85 Update 19.05 - przeskok
            }
        }
    }

    public class CellPane extends JPanel {

        private Color cellColor;
        
        public CellPane() {
                setBackground(Color.WHITE);
                
                addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cellColor = getBackground();
                    if(cellColor == Color.WHITE )setBackground(Color.BLACK);
                    if(cellColor == Color.BLACK )setBackground(Color.WHITE);
                }

                public void mouseExited(MouseEvent e) {
                    setBackground(cellColor);
                }
                
                public void mouseClicked(MouseEvent e) {
                    cellColor = getBackground();
                    if(cellColor == Color.WHITE )setBackground(Color.BLACK);
                    if(cellColor == Color.BLACK )setBackground(Color.WHITE);
                }
            });
        }
    }
}





