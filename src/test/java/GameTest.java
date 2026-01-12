import org.junit.jupiter.api.Test;

import java.util.List;

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
    void testGetPlayers(){
        List<Player> players = Game.getInstance().getPlayers();
        assertNotNull(players);
    }

    @Test
    void testNewGame(){
        assertNotNull(Game.getInstance().getItemFactory());

        Game.getInstance().newGame();
        assert(Game.getInstance().getRoundCount() == 0);
        assert(Game.getInstance().getCurrentTurn() == 0);
        assert(Game.getInstance().getPlayers().size() == 2);
        assert(Game.getInstance().getPlayers().get(0).getName().equals("Player 1"));
        assert(Game.getInstance().getPlayers().get(1).getName().equals("Player 2"));
        assert(Game.getInstance().getPlayers().get(0).getHealth() == 3);
        assert(Game.getInstance().getPlayers().get(1).getHealth() == 3);

        assert(Game.getInstance().getCurrentPlayer().getName().equals("Player 1"));
        assert(Game.getInstance().getNextPlayer().getName().equals("Player 2"));

        Game.getInstance().advanceTurn();

        assert(Game.getInstance().getCurrentPlayer().getName().equals("Player 2"));
        assert(Game.getInstance().getNextPlayer().getName().equals("Player 1"));

        Game.getInstance().getNextPlayer().handcuff();
        Game.getInstance().advanceTurn();

        assert(Game.getInstance().getCurrentPlayer().getName().equals("Player 2"));
        assert(Game.getInstance().getNextPlayer().getName().equals("Player 1"));
    }

    @Test
    void testNewRound(){
        Game.getInstance().newGame();
        assert(Game.getInstance().getRoundCount() == 0);
        Game.getInstance().newRound();
        assert(Game.getInstance().getRoundCount() == 1);
        assert(!Game.getInstance().getShotgun().getLoaded().isEmpty());
    }
}