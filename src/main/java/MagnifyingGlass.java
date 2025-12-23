public class MagnifyingGlass extends Item {
    public MagnifyingGlass() {
        super("Magnifying Glass");
    }

    @Override
    public boolean useItem(Player user, Player target, Shotgun shotgun) {
        if(shotgun.getLoaded().getFirst() == false){
            System.out.println("Shell is blank.");
            return true;
        }else if(shotgun.getLoaded().getFirst() == true){
            System.out.println("Shell is live.");
            return true;
        }else{
            System.out.println("No shell loaded.");
            return false;
        }
    }
}
