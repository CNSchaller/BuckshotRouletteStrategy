import java.util.Random;

public class Phone extends Item{
    private final Random random = new Random(); //use this to decide which shell to reveal

    public Phone(){
        super("Burner Phone");
    }

    @Override
    public boolean useItem(Player user, Player target, Shotgun shotgun) {
        if(shotgun.getLoaded() != null && !shotgun.getLoaded().isEmpty()) {
            int indexToReveal = random.nextInt(shotgun.getLoaded().size()); //get a random index of [0, loaded.size)
            if (shotgun.getLoaded().get(indexToReveal) == false) { //if loaded at that index is false
                System.out.println(indexToReveal + 1 + " shell is blank.");
                return true;
            } else { //if loaded at that index is true
                System.out.println(indexToReveal + 1 + " shell is live.");
                return true;
            }
        }else{
            System.out.println("No shells in gun.");
            return false;
        }
    }
}
