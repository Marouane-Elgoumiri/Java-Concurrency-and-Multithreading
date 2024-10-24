package org.example;

public class Main {
    public static void main(String[] args) {
        Boxer boxer1 = new Boxer("Hamid", 100);
        Boxer boxer2 = new Boxer("Said",100);
        Fight fight= new Fight(boxer1, boxer2);
        System.out.println("**************************Hello world!****************************");
        System.out.println("> Fight Arena:");
        fight.startFight();
    }
}