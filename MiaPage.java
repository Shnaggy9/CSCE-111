// Mia Aquilina Sec 505 Team 6: Shifts and Giggles

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MiaPage {
    private int score = 0;
    private int timeLeft = 30;
    private JLabel scorelab;
    private JLabel timelab;
    private JButton tbutton;
    private Timer gtime;
    private Timer ttime;
    private JButton start;
    private Random rand = new Random();

    public MiaPage() {
        // frame
        JFrame frame = new JFrame("Mia's Gallery Shootout");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 239, 213));

        // score 
        scorelab = new JLabel("Score: 0");
        scorelab.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scorelab.setBounds(20, 10, 150, 30);
        frame.add(scorelab);

        // timer 
        timelab = new JLabel("Time: 30");
        timelab.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        timelab.setBounds(400, 10, 100, 30);
        frame.add(timelab);

        // target button
        tbutton = new JButton();
        tbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        tbutton.setBounds(200, 200, 60, 60);
        tbutton.setBackground(Color.WHITE);
        tbutton.setVisible(false);

        // red square in target button
        JPanel redSquare = new JPanel(); // red square
        redSquare.setBackground(Color.RED);
        int squareSize = 20;
        redSquare.setBounds((60 - squareSize) / 2, (60 - squareSize) / 2, squareSize, squareSize);
        tbutton.setLayout(null);
        tbutton.add(redSquare);
        frame.add(tbutton);

        tbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                score++;
                scorelab.setText("Score: " + score);
                tbutton.setVisible(false);
            }
        });

        // start button
        start = new JButton("Start Game");
        start.setBounds(180, 400, 140, 30);
        frame.add(start);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // countdown timer
        gtime = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timelab.setText("Time: " + timeLeft);

                // game stops when timer = 0
                if (timeLeft == 0) {
                    gtime.stop();
                    ttime.stop();
                    tbutton.setVisible(false);
                    JOptionPane.showMessageDialog(frame, "Your time is up! Final Score: " + score);
                    start.setEnabled(true);
                }
            }
        });

        // prompts random spot for target
        ttime = new Timer(1200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = rand.nextInt(frame.getWidth() - 80);
                int y = rand.nextInt(frame.getHeight() - 120) + 50;
                tbutton.setBounds(x, y, 60, 60);
                tbutton.setVisible(true);
            }
        });

        frame.setVisible(true);
    }

    private void startGame() {
        score = 0;
        timeLeft = 30;
        scorelab.setText("Score: 0");
        timelab.setText("Time: 30");
        start.setEnabled(false);
        tbutton.setVisible(false);
        gtime.start();
        ttime.start();
    }

}
