import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shotgun {
    static final int MAX_LOAD = 10;
    private List<Boolean> loaded;
    public Random random;
    private int liveShells;
    private int blankShells;
    private int amountLoaded;

    public Shotgun(Random random) {
        this.random = random;
        this.liveShells = 0;
        this.blankShells = 0;
        this.amountLoaded = 0;
        this.loaded = new ArrayList<>();
    }

    public int getBlankShells() {
        return blankShells;
    }

    public int getLiveShells() {
        return liveShells;
    }

    public int getAmountLoaded() {
        return amountLoaded;
    }

    public List<Boolean> getLoaded(){
        return loaded;
    }

    public void setLiveShells(int liveShells) {
        this.liveShells = liveShells;
    }

    public void setBlankShells(int blankShells) {
        this.blankShells = blankShells;
    }

    public void updateAmountLoaded() {
        this.amountLoaded = liveShells + blankShells;
    }

    public void loadShotgun() {
        this.amountLoaded = random.nextInt(MAX_LOAD-2) + 3; //range [3, 10]
        this.liveShells = random.nextInt(amountLoaded-1) + 1; //range [1, amountLoaded)
        this.blankShells = amountLoaded - liveShells;
        this.loaded = new ArrayList<>(amountLoaded);

        List<Integer> liveShellIndexes = new ArrayList<>();
        int randomIndex;

        while(liveShellIndexes.size() < liveShells) {
            randomIndex = random.nextInt(amountLoaded); //range [0, amountLoaded)
            if(liveShellIndexes.contains(randomIndex)) { //if that index is already in there, try again
                continue;
            }else {
                liveShellIndexes.add(randomIndex);
            }
        }

        for(int i = 0; i < this.amountLoaded; i++){ //create list of all falses
            loaded.add(false);
        }

        for(int i = 0; i < liveShellIndexes.size(); i++){ //populate with random trues (live shells)
            loaded.set(liveShellIndexes.get(i), true);
        }
    }

    public Boolean shoot(){
        if(getLoaded().size() > 0) {
            Boolean shot = getLoaded().get(0);
            getLoaded().remove(0);
            return shot;
        }
        else return null;
    }
}
