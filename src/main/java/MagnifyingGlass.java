public class MagnifyingGlass extends Item {
    public MagnifyingGlass() {
        super("Magnifying Glass");
    }

    @Override
    public void useItem(Player user, Player target, Shotgun shotgun) {
        if(shotgun.getLoaded().getFirst() == false){
            System.out.println("Shell is blank.");
        }else if(shotgun.getLoaded().getFirst() == true){
            System.out.println("Shell is live.");
        }else{
            System.out.println("No shell loaded.");
        }
    }
}
