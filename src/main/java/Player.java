import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int INTIAL_HEALTH = 3;
    private final int INITIAL_HANDCUFF_VALUE = 0;
    private final int MAX_ITEMS = 8;
    private int health;
    private int handcuffed;
    private String name;
    private List<Item> items = new ArrayList<>();
    private boolean turnRehash = false;

    public Player(String name) {
        this.health = INTIAL_HEALTH;
        this.handcuffed = INITIAL_HANDCUFF_VALUE;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public int getHandcuffed(){
        return this.handcuffed;
    }

    public void heal(int amount_healed){
        this.health += amount_healed;
    }

    public void loseHealth(int amount_lost){
        this.health -= amount_lost;
    }

    public void addItem(Item item){
        if(items.size() < MAX_ITEMS){
            this.items.add(item);
        }
    }

    public void useItem(int index, Player target, Shotgun shotgun){
        if(items.get(index) != null){
            if(items.get(index).useItem(this, target, shotgun)){
                items.remove(index);
            }
        }
    }

    public void handcuff(){
        this.handcuffed++;
    }

    public void printItems(){
        System.out.println("----------Items----------");
        for (int i = 0; i < 8; i++) {
            if (i < items.size() && items.get(i) != null) {
                System.out.println("Slot " + (i + 1) + ": " + items.get(i).getName());
            } else {
                System.out.println("Slot " + (i + 1) + ": (Empty)");
            }
        }
    }

    public void printLives(){
        System.out.println("----------Lives----------");
        for(int i = 0; i < health; i++){
            System.out.print("\u2764\uFE0F");
        }
        System.out.println();
    }

    public void shootSomeone(Player target, Shotgun shotgun){
        boolean result = shotgun.shoot();
        if(target == this){ //if targeting self
            if(result){ //if live round
                if(shotgun.getSawedOff()){ //if sawed off
                    loseHealth(2);
                    return;
                }else { //if not sawed off
                    loseHealth(1);
                    return;
                }
            }else  {
                this.turnRehash = true;
                return;
            }
        }else if(target != null){ //if target is someone else
            if(result){// if live round
                if(shotgun.getSawedOff()){ //if sawed off
                    target.loseHealth(2);
                    return;
                }else { //if not sawed off
                    target.loseHealth(1);
                    return;
                }
            }else { //if blank round, do nothing
                return;
            }
        }
    }
}
