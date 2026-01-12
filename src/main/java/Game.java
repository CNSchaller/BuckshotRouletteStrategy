import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//singleton game manager, has fields for shotgun class, characters class, and round count
public class Game {
    private Shotgun shotgun;
    private List<Player> players; //list of players
    private int roundCount; //counter for rounds (increments after shotgun is out of bullets)
    final Random rand; //random integer value
    private static Game instance;
    private int currentTurn;

    private Game(){
        this.roundCount = 0;
        this.rand = new Random();
        this.shotgun = new Shotgun(rand);
        this.players = new ArrayList<>();
        this.currentTurn = 0;
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

    public int getCurrentTurn(){
        return this.currentTurn;
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public Player getCurrentPlayer(){
        return players.get(currentTurn);
    }

    public Player getNextPlayer(){
        return players.get((currentTurn+1) % players.size());
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

    public void printStats(){
        System.out.println("Round #" + this.roundCount);
        System.out.println("Current turn: Player " + this.currentTurn);
        System.out.print("Player 1: ");
        this.players.get(0).printLives();
        this.players.get(0).printItems();

        System.out.print("Player 2: ");
        this.players.get(1).printLives();
        this.players.get(1).printItems();
    }

    public void newGame(){
        reset();
        shotgun.loadShotgun();
        this.currentTurn = 0; //make the first player the first turn on new game
        this.players.clear();
        this.players.add(new Player("Player 1"));
        this.players.add(new Player("Player 2"));

        printStats();
    }

    public void advanceTurn() {
        currentTurn = (currentTurn + 1) % players.size();

        // Skip handcuffed players
        while (players.get(currentTurn).getHandcuffed()) {
            players.get(currentTurn).unhandcuff(); // handcuffs wear off
            currentTurn = (currentTurn + 1) % players.size();
        }
    }

    public void newRound (){
        incrementRoundCount();
        shotgun.loadShotgun();
        printStats();
    }

}