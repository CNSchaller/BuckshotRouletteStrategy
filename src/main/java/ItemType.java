import java.util.Random;

public enum ItemType {
    BEER,
    CIGARETTE,
    HANDCUFFS,
    HANDSAW,
    MAGNIFYINGGLASS,
    PHONE,
    ADRENALINE;

    private static final Random RANDOM = new Random();

    public static ItemType random() {
        ItemType[] values = values();
        return values[RANDOM.nextInt(values.length)];
    }
}
