package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private JLabel counterLabel;
    private JButton startButton;
    private JButton suspendButton;
    private JButton resumeButton;
    private JButton quitButton;
    private Counter counter;

    public MyFrame() {
        setTitle("Counter Application");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        counterLabel = new JLabel("0");
        add(counterLabel);

        startButton = new JButton("Start");
        suspendButton = new JButton("Suspend");
        resumeButton = new JButton("Resume");
        quitButton = new JButton("Quit");

        add(startButton);
        add(suspendButton);
        add(resumeButton);
        add(quitButton);

        counter = new Counter(1000, this);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter.startCounter();
                if (!counter.isAlive()) {
                    counter.start();
                }
            }
        });

        suspendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter.stopCounter();
            }
        });

        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter.startCounter();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void updateCounter(int value) {
        counterLabel.setText(String.valueOf(value));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }
}