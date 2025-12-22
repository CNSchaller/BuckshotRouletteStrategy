public class HandSaw extends Item{
    public HandSaw(){
        super("Hand Saw");
    }

    @Override
    public void useItem(Player user, Player target, Shotgun shotgun){
        if(shotgun != null){
            shotgun.sawOff();
        }else{
            System.out.println("No shotgun found");
        }
    }
}
