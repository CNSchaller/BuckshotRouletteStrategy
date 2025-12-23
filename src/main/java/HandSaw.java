public class HandSaw extends Item{
    public HandSaw(){
        super("Hand Saw");
    }

    @Override
    public boolean useItem(Player user, Player target, Shotgun shotgun){
        if(shotgun != null){
            shotgun.sawOff();
            return true;
        }else{
            System.out.println("No shotgun found");
            return false;
        }
    }
}
