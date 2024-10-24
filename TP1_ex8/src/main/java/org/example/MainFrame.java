package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainFrame extends JFrame {
    private JLabel timeLabel;
    private Clock clock;
    private JCheckBox showFullDateCheckBox;

    public MainFrame() {
        setTitle("Clock Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("Current Time:");
        add(timeLabel);

        clock = new Clock();
        add(clock);

        showFullDateCheckBox = new JCheckBox("Show Full Date");
        add(showFullDateCheckBox);

        showFullDateCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (showFullDateCheckBox.isSelected()) {
                    clock.setFormat(DateFormat.getDateTimeInstance());
                } else {
                    clock.setFormat(new SimpleDateFormat("HH:mm:ss"));
                }
            }
        });

        Thread clockThread = new Thread(clock);
        clockThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}