public class Handcuffs extends Item{
    public Handcuffs(){
        super("Handcuffs");
    }

    @Override
    public boolean useItem(Player user, Player target, Shotgun shotgun){
        if(target != null){
            target.handcuff();
            return true;
        }else{
            System.out.println("No target found.");
            return false;
        }
    }
}
