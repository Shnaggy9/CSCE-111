/* 
Team Number: Team 6
Team Members: Parker Hitchcock, Chiggy Ogara, Domenic Hucik, Mia Aquilina
Team Name: Shifts and Giggles
Class and Section: CSCE 111- 505
April 11, 2025
*/ 

import javax.swing.*;
import java.awt.*;


public class ProjectMain {
    public static void main(String[] args) {

        //creating the frame and setting size
        JFrame frame = new JFrame("Team: Shifts and Giggles");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel holds all the stuff
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 235, 205));

        //title label
        JLabel title = new JLabel("Welcome to Shifts and Giggles Carnival!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        title.setForeground(new Color(200, 0, 0));

        //buttons for each team member
        JButton PButton = new JButton("Parker's Ball Toss");
        JButton CButton = new JButton("Chiggy");
        JButton DButton = new JButton("Domenic");
        JButton MButton = new JButton("Mia");

        //styling the buttons
        JButton[] buttons = {PButton, CButton, DButton, MButton};
        for (JButton button : buttons) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(250, 40));
            button.setBackground(Color.YELLOW);
            button.setForeground(Color.RED);
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            panel.add(Box.createRigidArea(new Dimension(0, 10))); //adding space between buttons
            panel.add(button);
        }

        //adding title and spacing
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); //adding space between title and buttons


        //adding buttons to the panel
        panel.add(PButton);
        panel.add(CButton);
        panel.add(DButton);
        panel.add(MButton);

        //action listeners for each button
        PButton.addActionListener(e -> new ParkerPage());
        CButton.addActionListener(e -> new ChiggyPage());
        DButton.addActionListener(e -> new DomenicPage());
        MButton.addActionListener(e -> new MiaPage());

        //adding panel to the frame
        frame.add(panel);

        //setting the frame to be visible
        frame.setVisible(true);        
    }
}
