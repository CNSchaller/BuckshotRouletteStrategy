public class ItemFactory {
    public static Item create(String type) {
        if(type.equalsIgnoreCase("beer")) {
            return new Beer();
        }else if(type.equalsIgnoreCase("cigarette")) {
            return new Cigarette();
        }else if(type.equalsIgnoreCase("handcuffs")) {
            return new Handcuffs();
        }else if(type.equalsIgnoreCase("handsaw")) {
            return new HandSaw();
        }else if(type.equalsIgnoreCase("magnifying glass")) {
            return new MagnifyingGlass();
        }else if(type.equalsIgnoreCase("phone")) {
            return new Phone();
        }else if(type.equalsIgnoreCase("adrenaline")) {
            return new Adrenaline();
        }
        return null;
    }
}
