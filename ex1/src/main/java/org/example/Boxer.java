package org.example;

public class Boxer {
    private String name;
    private int health;
    public Boxer(String name, int health) {
        this.name = name;
        this.health = health;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void receivePunch(int force){
        health -= force;
        if(health <= 0){
            health = 0;
        }
    }
}
