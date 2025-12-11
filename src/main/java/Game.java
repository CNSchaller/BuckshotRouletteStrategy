import java.util.Random;

//singleton game manager, has fields for shotgun class, characters class, and round count
public class Game {
    private Shotgun shotgun;
    //put characters class here
    private int roundCount; //counter for rounds (increments after shotgun is out of bullets)
    final Random rand; //random integer value
    private static Game instance;

    private Game(){
        this.roundCount = 0;
        this.rand = new Random();
        this.shotgun = new Shotgun(rand);
    }

    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public int getRoundCount(){
        return this.roundCount;
    }

    public void incrementRoundCount(){
        this.roundCount++;
    }

    public void setRoundCount(int roundCount){
        this.roundCount = roundCount;
    }

    public void reset(){
        this.roundCount = 0;
    }

    public Shotgun getShotgun(){
        return this.shotgun;
    }

    public void newRound (){
        incrementRoundCount();
        shotgun.loadShotgun();
    }

}