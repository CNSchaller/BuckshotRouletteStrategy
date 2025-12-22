public class Player {
    private int health = 4;
    private int handcuffed = 0;

    public void heal(int amount_healed){
        this.health += amount_healed;
    }

    public int getHealth(){
        return this.health;
    }

    public int getHandcuffed(){
        return this.handcuffed;
    }

    public void handcuff(){
        this.handcuffed++;
    }


}
