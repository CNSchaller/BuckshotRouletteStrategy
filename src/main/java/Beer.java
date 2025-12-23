public class Beer extends Item {
    public Beer() {
        super("Beer");
    }

    @Override
    public boolean useItem(Player user, Player target, Shotgun shotgun) {
        if(!shotgun.getLoaded().isEmpty() && shotgun.getLoaded() != null){
            if(shotgun.shoot() == false){
                System.out.println("Shell was blank.");
                return true;
            }else{
                System.out.println("Shell was live.");
                return true;
            }
        }else{
            System.out.println("No shell loaded.");
            return false;
        }
    }
}
