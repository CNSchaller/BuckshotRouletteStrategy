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


}
