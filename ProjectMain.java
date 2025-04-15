/* 
Team Number: Team 6
Team Members: Parker Hitchcock, Chiggy Ogara, Domenic Hucik, Mia Aquilina
Team Name: Shifts and Giggles
Class and Section: CSCE 111- 505
April 11, 2025
*/ 

import javax.swing.*;

public class ProjectMain {
    public static void main(String[] args) {

        //creating the frame and setting size
        JFrame frame = new JFrame("Team: Shifts and Giggles");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel holds all the stuff
        JPanel panel = new JPanel();

        //buttons for each team member
        JButton PButton = new JButton("Parker");
        JButton CButton = new JButton("Chiggy");
        JButton DButton = new JButton("Domenic");
        JButton MButton = new JButton("Mia");


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
