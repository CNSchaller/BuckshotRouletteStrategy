
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameTest {
    @Test
    void testConstructor(){ //test to make sure game is being instantiated
        assertNotNull(Game.getInstance());
    }

    @Test
    void testGetRoundCount(){ //make sure roundcount is 0 on init
        assert(Game.getInstance().getRoundCount() == 0);
    }

    @Test
    void testSetRoundCount(){
        Game.getInstance().setRoundCount(4);
        assert(Game.getInstance().getRoundCount() == 4);
    }

    @Test
    void testIncrementRoundCount(){
        Game.getInstance().setRoundCount(0);
        Game.getInstance().incrementRoundCount();
        assert(Game.getInstance().getRoundCount() == 1);
        Game.getInstance().incrementRoundCount();
        assert(Game.getInstance().getRoundCount() == 2);
    }

    @Test
    void testResetRoundCount(){
        Game.getInstance().setRoundCount(4);
        assert(Game.getInstance().getRoundCount() == 4);
        Game.getInstance().reset();
        assert(Game.getInstance().getRoundCount() == 0);
    }

    @Test
    void testGetShotgun(){
        assertNotNull(Game.getInstance().getShotgun());
    }

    @Test
    void testNewRound(){
        int old = Game.getInstance().getRoundCount();
        Game.getInstance().newRound();
        assert(old !=  Game.getInstance().getRoundCount());
        assert(Game.getInstance().getRoundCount() == old+1);
    }
}