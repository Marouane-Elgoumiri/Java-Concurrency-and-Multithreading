package org.example;

public class Fight {
    private Boxer boxer1;
    private Boxer boxer2;

    public Fight(Boxer boxer1, Boxer boxer2) {
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
    }
    public void startFight(){
        System.out.println("The fight will start between " + boxer1.getName() + " and " + boxer2.getName());
        while(boxer1.getHealth() > 0 && boxer2.getHealth() > 0) {
            conductRound(boxer1, boxer2);
            if(boxer1.getHealth() > 0) {
                conductRound(boxer1, boxer2);
            }
        }
        if(boxer2.getHealth() == 0) {
            System.out.println("Boxer "+boxer1.getName()+" wins!");
        }else{
            System.out.println("Boxer "+boxer2.getName()+" wins!");
        }
    }
    public void conductRound(Boxer attacker, Boxer defender){
        int force = attacker.getHealth();
        defender.receivePunch(force);
        System.out.println(attacker.getName() + " hits "  + defender.getName() + " with force " + force + "." +
                defender.getName() + " has now " + defender.getHealth() + " HP ");
        try{
            int time = (int) (Math.random() * 600 +1);
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
