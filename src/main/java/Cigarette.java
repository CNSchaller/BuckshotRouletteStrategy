public class Cigarette extends Item {
    private final int HEAL_AMOUNT = 1;

    public Cigarette(){
        super("Cigarette");
    }

    @Override
    public boolean useItem(Player user, Player target, Shotgun shotgun) {
        user.heal(HEAL_AMOUNT);
        return true;
    }
}
