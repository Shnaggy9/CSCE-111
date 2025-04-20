import java.awt.*;
import javax.swing.*;

public class ParkerPage extends JFrame {
    //constructor for ParkerPage
    public ParkerPage() {
        //creating the frame and setting size
        setTitle("Parker's Ball Toss");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //creating the panel to hold the components
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 240, 200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //title
        JLabel title = new JLabel("Toss the Ball!");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // label to tell the user what to do
        JLabel instruction = new JLabel("Guess 1, 2 or 3");
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);

        //input box
        JTextField input = new JTextField(5);
        input.setMaximumSize(new Dimension(100, 25));
        input.setAlignmentX(Component.CENTER_ALIGNMENT);

        //button to toss the ball
        JButton button = new JButton("Toss!");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.YELLOW);
        button.setForeground(Color.RED);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));


        //label to tell the user if they won or lost
        JLabel result = new JLabel("");
        result.setAlignmentX(Component.CENTER_ALIGNMENT);

        //action after the button is pressed
        button.addActionListener(e -> {
            String type = input.getText();
            int ballSpot = (int) (Math.random() * 3) + 1; //random number between 1 and 3

            //checking if the guess is valid
        if (type.equals("1") || type.equals("2") || type.equals("3")) {
            int guess = Integer.parseInt(type);

            //if they guessed the right spot
            if (guess == ballSpot) {
                result.setText("Nice Shot! You hit it!");
            } else {
                result.setText("You missed! It was in spot " + ballSpot);
            }
        } else {
            result.setText("Invalid input");
        }
    });

    panel.add(Box.createRigidArea(new Dimension(0, 15)));
    panel.add(title);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(instruction);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(input);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(button);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(result);

    //adding the components to the panel
    add(panel);
    setVisible(true);
    } 
}
