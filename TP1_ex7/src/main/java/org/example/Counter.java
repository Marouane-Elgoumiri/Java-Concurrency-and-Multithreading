package org.example;

public class Counter extends Thread {
    private int cpt;
    private int tempo;
    private MyFrame frame;
    private boolean running;

    public Counter(int tempo, MyFrame frame) {
        this.cpt = 0;
        this.tempo = tempo;
        this.frame = frame;
        this.running = false;
    }

    public void run() {
        while (true) {
            if (running) {
                cpt++;
                frame.updateCounter(cpt);
                try {
                    Thread.sleep(tempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void startCounter() {
        running = true;
    }

    public void stopCounter() {
        running = false;
    }
}