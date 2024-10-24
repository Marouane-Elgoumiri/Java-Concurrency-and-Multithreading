package org.example;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends JTextField implements Runnable {
    private DateFormat format;

    public Clock() {
        this.format = new SimpleDateFormat("HH:mm:ss");
        setEditable(false);
    }

    public void setFormat(DateFormat format) {
        this.format = format;
    }

    @Override
    public void run() {
        while (true) {
            setText(format.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}