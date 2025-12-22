public class Player {
    private int health = 4;

    public void heal(int amount_healed){
        this.health += amount_healed;
    }

    public int getHealth(){
        return this.health;
    }
}
