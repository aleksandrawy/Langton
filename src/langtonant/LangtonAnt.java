//package langtonant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.MatteBorder;


/**
 *
 * @author Aleksandra
 */
public class LangtonAnt {

    public static void main(String[] args) {
        System.out.println("hej");
        new Window();
        System.out.println("nara");
    }
}

class Window extends LangtonAnt{

    private JButton przyciski[];
    private Timer timer;
    private boolean start = false;
    private Ant[] ants;
            
        Window(){

            JFrame frame = new JFrame("Langton Ant");
            System.out.println("7");
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            final int screenWidth = screenSize.width;       
            final int screenHeight = screenSize.height;                
            frame.setSize(screenWidth, screenHeight);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            
            frame.add(new Panel(), BorderLayout.LINE_START);
            frame.add(new Buttons());
            System.out.println("5");
            frame.setVisible(true);
            
            
            

        }

    public class Buttons extends JPanel implements ActionListener{

            JTextField Counter = new JTextField(10); 
            JTextField AddSteps = new JTextField(10);
            JLabel StepLabel = new JLabel("STEPS: ");
            
        public Buttons(){
            
            przyciski = new JButton[4];
            przyciski[0] = new JButton("START");
            przyciski[1] = new JButton("STOP");
            przyciski[2] = new JButton("ADD ANT");
            przyciski[3] = new JButton("DO STEPS");
            setLayout(null);
            
            add(przyciski[0]);
            add(przyciski[1]);
            add(przyciski[2]);
            add(przyciski[3]);
            add(Counter);
            add(AddSteps);
            add(StepLabel); 
            
        //Przyciski
            przyciski[0].setBounds(10, 10, 100, 40);
            przyciski[1].setBounds(10, 60, 100, 40);
        //Licznik kroków
            StepLabel.setBounds(40, 100, 50, 30);                     
            Counter.setBounds(10, 130, 100, 30);
            Counter.setText(String.valueOf(0));
        //Dodawanie mrówki    
            przyciski[2].setBounds(10, 170, 100, 40);
            
        //przeskok o liczbę kroków
            AddSteps.setBounds(10, 220, 100, 30);           
            przyciski[3].setBounds(10, 260, 100, 40);  
            
            przyciski[0].addActionListener(this);
            przyciski[1].addActionListener(this);
            przyciski[2].addActionListener(this);
            przyciski[3].addActionListener(this);
        }
        
        public void actionPerformed(ActionEvent e){
            Object click = e.getSource();
            long aSteps;
            long aStepsToJump;
            
            if(click==przyciski[0]) start = true;
            if(click==przyciski[1]) start = false;
            if(click==przyciski[2]);
            if(click==przyciski[3]){
            aSteps = Long.parseLong(Counter.getText());    
            aStepsToJump = Long.parseLong(AddSteps.getText());
            Counter.setText(String.valueOf(aSteps += aStepsToJump));
            }
        }
    }
    
    public class Panel extends JPanel {
        
        GridBagConstraints grid;
        
        class DrawingAnt extends TimerTask{
        
        private Color cellColor;
        
        public void run(){
            //if(start){       
            System.out.println("1");
                for(int i = 0; i < 1; i++){
                    grid.gridx = ants[i].getX();
                    grid.gridy = ants[i].getY();
                    cellColor = getBackground();
                    if(cellColor == Color.WHITE){
                        setBackground(Color.BLACK);
                        ants[i].setX(ants[i].getX() + 1);
                    }
                    
                }
          //  }
        }
    }
        
        public Panel() {
            setLayout(new GridBagLayout());
            
            grid = new GridBagConstraints();
            
            ants = new Ant[3];
            System.out.println("3");
            for(int i = 0; i < 2; i++){
                Random randX = new Random();
                Random randY = new Random();
                Color color = Color.BLACK;
                int x_rand = randX.nextInt(110);
                int y_rand = randY.nextInt(60);
                ants[i] = new Ant(x_rand, y_rand, color);
                
                System.out.println("x: " + x_rand + " y: " + y_rand);
            }
            
            timer = new Timer();
            timer.schedule(new DrawingAnt(), 20);
            
            for (int row = 0; row < 60; row++) {
                for (int column = 0; column < 110; column++) {
                    grid.gridx = column;
                    grid.gridy = row;

                    CellPanel cellPanel = new CellPanel();
                    
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
                    cellPanel.setBorder(border);
                    add(cellPanel, grid);                  
                }
            }
            

        }
    
    

    
}
    
    public class Ant extends Panel{
        private int position[];
        private Color antColor;
        private int direction;
        private Color cell;
        
        public Ant(int x, int y, Color aColor){
            position[0] = x;
            position[1] = y;
            antColor = aColor; 
            direction = 0;
            cell = getBackground();
        }
        
        public int getX(){
            return position[0];
        }
        
        public int getY(){
            return position[1];
        }
        
        public Color getColor(){
            return antColor;
        }
        
        public int getDirection(){
            return direction;
        }
        
        public void setX(int x){
            position[0] = x;
        }
        
        public void setY(int y){
            position[1] = y;
        }
        
        public void setColor(Color aColor){
            antColor = aColor;
        }
        
        public void setDirection(int direct){
            if(direct < 4)
                direction = direct;
            else
                direction = 3;
        }
    }
    
    

    public class CellPanel extends JPanel {

        private Color cellColor;
        
        public CellPanel() {
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
