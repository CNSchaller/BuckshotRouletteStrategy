public class Beer extends Item {
    public Beer() {
        super("Beer");
    }

    @Override
    public void useItem(Player user, Player target, Shotgun shotgun) {
        if(!shotgun.getLoaded().isEmpty() && shotgun.getLoaded() != null){
            if(shotgun.shoot() == false){
                System.out.println("Shell was blank.");
            }else{
                System.out.println("Shell was live.");
            }
        }else{
            System.out.println("No shell loaded.");
        }
    }
}
