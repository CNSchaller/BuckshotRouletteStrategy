import org.junit.jupiter.api.Test;

public class ItemTypeTest {
    @Test
    public void ItemTypeTest(){
        ItemType type = ItemType.random();
        ItemType type2 = ItemType.random();
        ItemType type3 = ItemType.random();
        System.out.println(type);
        System.out.println(type2);
        System.out.println(type3);

    }
}
