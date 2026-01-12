import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemFactoryTest {
    @Test
    public void testCreateItem() {
        ItemFactory itemFactory = new ItemFactory();
        assertNotNull(itemFactory);

        Item phone = itemFactory.create(ItemType.PHONE);
        assertNotNull(phone);
        assert(phone.getName().equals("Burner Phone"));

        Item beer = itemFactory.create(ItemType.BEER);
        assertNotNull(beer);
        assert(beer.getName().equals("Beer"));

        Item cig =  itemFactory.create(ItemType.CIGARETTE);
        assertNotNull(cig);
        assert(cig.getName().equals("Cigarette"));

        Item adrenaline = itemFactory.create(ItemType.ADRENALINE);
        assertNotNull(adrenaline);
        assert(adrenaline.getName().equals("Adrenaline"));

        Item handcuffs = itemFactory.create(ItemType.HANDCUFFS);
        assertNotNull(handcuffs);
        assert(handcuffs.getName().equals("Handcuffs"));

        Item handsaw = itemFactory.create(ItemType.HANDSAW);
        assertNotNull(handsaw);
        assert(handsaw.getName().equals("Hand Saw"));

        Item madnifying = itemFactory.create(ItemType.MAGNIFYINGGLASS);
        assertNotNull(madnifying);
        assert(madnifying.getName().equals("Magnifying Glass"));
    }
}
