
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Domenic Hucik
 * UIN: 433008000
 * CSCE 111-505
 * 04/21/2025
 */
public class DomenicPage extends JFrame {
    
    private int targetNumber;
    private int attempts;
    private JTextField guessInput;
    private JLabel feedbackLabel;

    public DomenicPage() {

        // Frame setup
        setTitle("Domenic's Guess the Number Game!");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Keeps the main frame open
        setLocationRelativeTo(null);

        // Panel setup
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(224, 255, 255));

        // Title Label
        JLabel title = new JLabel("Guess the number between 1-100");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Description of Game
        JLabel instructions = new JLabel("<html><center>You have 7 tries to guess the number.<br>If it is too high or too low I will let you know.<center></html>");
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructions.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        panel.add(instructions);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Input field
        guessInput = new JTextField();
        guessInput.setMaximumSize(new Dimension(200, 30));
        guessInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(guessInput);
        
        // Guess button
        JButton guessButton = new JButton("Guess!");
        guessButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(guessButton);

        // Feedback label
        feedbackLabel = new JLabel("You have 7 attempts.");
        feedbackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedbackLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(feedbackLabel);

        add(panel);
        setVisible(true);

        // Start up new game
        resetGame();

        guessButton.addActionListener(e -> checkGuess());
    }

    // Start the game with a random number and 7 attempts
    private void resetGame() {
        Random rand = new Random();
        targetNumber = rand.nextInt(100) + 1;
        attempts = 7;
    }

    // Check for the user's guess and updates the game
    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessInput.getText());
            attempts--;

            if (guess == targetNumber) {
                feedbackLabel.setText("Winner Winner! You guessed correct!");
                disableInput();
            } else if (attempts == 0) {
                feedbackLabel.setText("You are out of attempts. The number was " + targetNumber);
                disableInput();
            } else if (guess < targetNumber) {
                feedbackLabel.setText("Too low! " + attempts + " attempts remain.");
            } else {
                feedbackLabel.setText("Too high! " + attempts + " attempts remain.");
            }

            guessInput.setText("");
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Please enter a valid number.");
        }
    }

    // Disables user input once the game is over
    private void disableInput() {
        guessInput.setEnabled(false);
    }
}