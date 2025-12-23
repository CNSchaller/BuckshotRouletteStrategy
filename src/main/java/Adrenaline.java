import java.util.Random;

public class Adrenaline extends Item{ //for now, it will randomly choose an item, but change to user input
    private final Random random = new Random();

    Adrenaline() {
        super("Adrenaline");
    }

    @Override
    public boolean useItem(Player user, Player target, Shotgun shotgun) {
        return false; //return to implement this
    }
}
