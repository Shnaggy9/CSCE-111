/*
 * Name: Chigozie Ogara
 * UIN: [Your UIN]
 * Section: CSCE 111-505
 * Date: April 11, 2025
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.Random;
 
 public class ChiggyPage extends JFrame {
     private int correctCup;
     private final Random rand = new Random();
 
     // Emojis for random display
     private final String[] cupEmojis = { "🥤", "🪣", "🧃", "🍶", "🍵" };
     private final String[] prizeEmojis = { "🏆", "🎁", "🧸", "💎", "🎈" };
     private final String[] missEmojis = { "🪰", "💨", "🕳️", "🗿", "🦴" };
 
     // Store buttons so we can update their emoji each round
     private final JButton[] cupButtons = new JButton[3];
 
     public ChiggyPage() {
         // Emoji font fix for popups
         UIManager.put("OptionPane.messageFont", new Font("Segoe UI Emoji", Font.PLAIN, 18));
 
         // Frame setup
         setTitle("Chiggy's Cup Game!");
         setSize(450, 300);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
         // Panel setup
         JPanel panel = new JPanel();
         panel.setBackground(new Color(255, 250, 230));
         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 
         JLabel instructions = new JLabel("Click a cup to find the prize!");
         instructions.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
         instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
         panel.add(Box.createRigidArea(new Dimension(0, 15)));
         panel.add(instructions);
         panel.add(Box.createRigidArea(new Dimension(0, 15)));
 
         JPanel cupPanel = new JPanel();
         cupPanel.setBackground(new Color(255, 250, 230));
         cupPanel.setLayout(new FlowLayout());
 
         // Create cup buttons with placeholder emoji
         for (int i = 0; i < 3; i++) {
             JButton cup = new JButton("🥤");
             cup.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));
             int index = i;
             cup.addActionListener(e -> {
                 reveal(index);
                 randomizeGame(); // update cup icons & winning index
             });
             cupButtons[i] = cup;
             cupPanel.add(cup);
         }
 
         panel.add(cupPanel);
         add(panel);
 
         // Start with initial random state
         randomizeGame();
 
         setVisible(true);
     }
 
     private void reveal(int choice) {
         if (choice == correctCup) {
             String prize = prizeEmojis[rand.nextInt(prizeEmojis.length)];
             JOptionPane.showMessageDialog(this, "You found it! " + prize,
                     "Winner", JOptionPane.INFORMATION_MESSAGE);
         } else {
             String miss = missEmojis[rand.nextInt(missEmojis.length)];
             JOptionPane.showMessageDialog(this, "Not here... " + miss,
                     "Try Again", JOptionPane.WARNING_MESSAGE);
         }
     }
 
     private void randomizeGame() {
         correctCup = rand.nextInt(3);
         for (JButton button : cupButtons) {
             String randomCup = cupEmojis[rand.nextInt(cupEmojis.length)];
             button.setText(randomCup);
         }
     }
 }
 