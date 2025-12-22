public class Handcuffs extends Item{
    public Handcuffs(){
        super("Handcuffs");
    }

    @Override
    public void useItem(Player user, Player target, Shotgun shotgun){
        if(target != null){
            target.handcuff();
        }else{
            System.out.println("No target found.");
        }
    }
}
