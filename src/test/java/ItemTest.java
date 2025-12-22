import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTest {
    Player user;
    Player target;
    Random random = new Random();
    Shotgun shotgun;

    @BeforeEach
    public void setup(){
        user = new Player();
        target = new Player();
        shotgun = new Shotgun(random);
    }

    @Test
    public void testCig(){
        Item cig = new Cigarette();
        assertNotNull(cig);
        assertNotNull(user);
        shotgun.loadShotgun();

        assert(user.getHealth() == 4);
        cig.useItem(user, target, shotgun);
        assert(user.getHealth() == 5);
    }

    @Test
    public void testPhone(){
        Item phone = new Phone();
        shotgun.loadShotgun();
        shotgun.printLoaded();

        assertNotNull(phone);
        assert(phone.getName().equals("Burner Phone"));

        phone.useItem(user, target, shotgun);
        shotgun.shoot();
        phone.useItem(user, target, shotgun);
        shotgun.shoot();
        phone.useItem(user, target, shotgun);
        shotgun.shoot();
        phone.useItem(user, target, shotgun);
        shotgun.shoot();
        phone.useItem(user, target, shotgun);
        shotgun.shoot();
        phone.useItem(user, target, shotgun);
        shotgun.shoot();
        phone.useItem(user, target, shotgun);
        shotgun.shoot();
        phone.useItem(user, target, shotgun);
    }

    @Test
    public void testMagnifyingGlass(){
        Item magnifyingGlass = new MagnifyingGlass();
        assert(magnifyingGlass.getName().equals("Magnifying Glass"));
        assertNotNull(magnifyingGlass);
        shotgun.loadShotgun();
        shotgun.printLoaded();

        magnifyingGlass.useItem(user, target, shotgun);
    }

    @Test
    public void testBeer(){
        Item beer = new Beer();
        assert(beer.getName().equals("Beer"));
        assertNotNull(beer);
        shotgun.loadShotgun();

        shotgun.printLoaded();
        beer.useItem(user, target, shotgun);
        shotgun.printLoaded();
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
        beer.useItem(user, target, shotgun);
    }

    @Test
    public void testHandSaw(){
        Item handSaw = new HandSaw();
        assert(handSaw.getName().equals("Hand Saw"));
        assertNotNull(handSaw);

        assert(shotgun.getSawedOff() == false);
        handSaw.useItem(user, target, shotgun);

        assert(shotgun.getSawedOff() == true);
    }

    @Test
    public void testHandcuffs(){
        Item handcuffs = new Handcuffs();
        assertNotNull(handcuffs);
        assert(handcuffs.getName().equals("Handcuffs"));

        assert(target.getHandcuffed() == 0);

        handcuffs.useItem(user, target, shotgun);

        assert(target.getHandcuffed() == 1);
    }
}
