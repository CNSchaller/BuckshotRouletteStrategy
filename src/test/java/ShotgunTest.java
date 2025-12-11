import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShotgunTest {
    @Test
    public void testConstructor(){
        Shotgun shotgun = new Shotgun(new Random());
        assertNotNull(shotgun);
    }

    @Test
    public void testGetters(){
        Shotgun shotgun = new Shotgun(new Random());

        assert(shotgun.getBlankShells() == 0);
        assert(shotgun.getLiveShells() == 0);
        assert(shotgun.getAmountLoaded() == 0);

        shotgun.setBlankShells(3);
        shotgun.setLiveShells(2);
        shotgun.updateAmountLoaded();

        assert(shotgun.getBlankShells() == 3);
        assert(shotgun.getLiveShells() == 2);
        assert(shotgun.getAmountLoaded() == 5);
    }

    @Test
    public void testLoadShotgun() {
        Shotgun shotgun = new Shotgun(new Random());

        shotgun.loadShotgun();
        assert(shotgun.getAmountLoaded() > 0 && shotgun.getAmountLoaded() <= 10);
        assert(shotgun.getBlankShells() > 0 && shotgun.getBlankShells() < shotgun.getAmountLoaded());
        assert(shotgun.getLiveShells() > 0 && shotgun.getLiveShells() < shotgun.getAmountLoaded());
        assert(shotgun.getAmountLoaded() == shotgun.getLiveShells() + shotgun.getBlankShells());
        assert(shotgun.getLoaded().size() == shotgun.getAmountLoaded());

        int trueCount = 0;

        for (boolean shell : shotgun.getLoaded()) {
            if (shell) {
                trueCount++;
            }
        }
        assert(trueCount == shotgun.getLiveShells());

        shotgun.loadShotgun();
        shotgun.loadShotgun();
        shotgun.loadShotgun();
        assert(shotgun.getAmountLoaded() > 0 && shotgun.getAmountLoaded() <= 10);
        assert(shotgun.getBlankShells() > 0 && shotgun.getBlankShells() < shotgun.getAmountLoaded());
        assert(shotgun.getLiveShells() > 0 && shotgun.getLiveShells() < shotgun.getAmountLoaded());
        assert(shotgun.getAmountLoaded() == shotgun.getLiveShells() + shotgun.getBlankShells());
        assert(shotgun.getLoaded().size() == shotgun.getAmountLoaded());

        trueCount = 0;

        for (boolean shell : shotgun.getLoaded()) {
            if (shell) {
                trueCount++;
            }
        }
        assert(trueCount == shotgun.getLiveShells());
    }

    @Test
    public void testShoot(){
        Shotgun shotgun = new Shotgun(new Random());

        shotgun.loadShotgun();
        int oldSize = shotgun.getLoaded().size();
        shotgun.shoot();
        assert(shotgun.getLoaded().size() != oldSize);
        assert(shotgun.getLoaded().size() == oldSize - 1);

        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        shotgun.shoot();
        assert(shotgun.getLoaded().size() == 0);
       // assert(shotgun.shoot() == null);
    }
}
