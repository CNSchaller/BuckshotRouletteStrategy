public class ItemFactory {
    public static Item create(ItemType type) {
        if(type == ItemType.BEER) {
            return new Beer();
        }else if(type == ItemType.CIGARETTE) {
            return new Cigarette();
        }else if(type == ItemType.HANDCUFFS) {
            return new Handcuffs();
        }else if(type == ItemType.HANDSAW) {
            return new HandSaw();
        }else if(type == ItemType.MAGNIFYINGGLASS) {
            return new MagnifyingGlass();
        }else if(type == ItemType.PHONE) {
            return new Phone();
        }else if(type == ItemType.ADRENALINE) {
            return new Adrenaline();
        }
        return null;
    }
}
