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
            Start.setBounds(70, 10, 100, 40);
            Stop.setBounds(70, 60, 100, 40);
        //Licznik kroków
            StepLabel.setBounds(100, 100, 50, 30);                     
            Counter.setBounds(70, 130, 100, 30);
        //Dodawanie mrówki    
            AddAnt.setBounds(70, 170, 100, 40);
            
        //przeskok o liczbę kroków
            AddSteps.setBounds(70, 220, 100, 30);           
            GoTo.setBounds(70, 260, 100, 40);
            
        }
    }
    
    public class Panel extends JPanel {

        public Panel() {
            setLayout(new GridBagLayout());
            
            GridBagConstraints grid = new GridBagConstraints();
            for (int row = 0; row < 60; row++) {
                for (int column = 0; column < 100; column++) {
                    grid.gridx = column;
                    grid.gridy = row;

                    CellPane cellPane = new CellPane();
                    
                    MatteBorder border = null;
                    if (row < 59) {
                        if (column < 99) {
                            border = new MatteBorder(1, 1, 0, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.BLACK);
                        }
                    } else {
                        if (column < 99) {
                            border = new MatteBorder(1, 1, 1, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                        }
                    }
                    cellPane.setBorder(border);
                    cellPane.setBounds(200, 10, 1700, 1000);
                    add(cellPane, grid);
                }
            }
        }
    }

    public class CellPane extends JPanel {


        public CellPane() {
            setBackground(Color.WHITE);
        }
    }
}



