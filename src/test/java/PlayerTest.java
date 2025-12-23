import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {
    @Test
    public void testGetters(){
        Player user = new Player("user");
        assertNotNull(user);
        assert(Objects.equals(user.getName(), "user"));
        assert(user.getHealth() == 3);
        assert(user.getItems().isEmpty());
        assert(user.getHandcuffed() == 0);
    }

    @Test
    public void testModifiers(){
        Player user = new Player("user");
        Player target = new Player("target");
        Shotgun shotgun = new Shotgun(new Random());
        Item hc = new Handcuffs();
        Item beer = new Beer();
        assertNotNull(user);

        assert(user.getHealth() == 3);

        user.heal(1);
        assert(user.getHealth() == 4);
        assert(target.getHandcuffed() == 0);

        user.loseHealth(2);
        assert(user.getHealth() == 2);

        assert(user.getItems().isEmpty());
        user.addItem(hc);
        assert(user.getItems().size() == 1);
        user.addItem(beer);
        assert(user.getItems().size() == 2);
        user.useItem(1, user, shotgun);
        assert(user.getItems().size() == 2);
        user.useItem(0, target, shotgun);
        assert(user.getItems().size() == 1);

        assert(target.getHandcuffed() == 1);
    }

    @Test
    public void testPrints(){
        Player user = new Player("user");
        Player target = new Player("target");
        Shotgun shotgun = new Shotgun(new Random());
        Item hc = new Handcuffs();
        Item beer = new Beer();

        user.addItem(hc);
        user.addItem(beer);
        user.printItems();

        user.useItem(0, user, shotgun);
        user.printItems();

        user.printLives();
    }

    @Test
    public void testShootSomeone(){
        Player user = new Player("user");
        Player target = new Player("target");
        Shotgun shotgun = new Shotgun(new Random());
        List<Boolean> rig = new ArrayList<>(Arrays.asList(false, false, true, true));
        shotgun.setLoaded(rig);

        user.shootSomeone(target, shotgun);
        assert(target.getHealth() == 3);
        user.shootSomeone(user, shotgun);
        assert(user.getHealth() == 3);

        user.shootSomeone(target, shotgun);
        assert(target.getHealth() == 2);
        user.shootSomeone(user, shotgun);
        assert(user.getHealth() == 2);
    }
}
