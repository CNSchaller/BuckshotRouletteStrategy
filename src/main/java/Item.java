public abstract class Item {
    private final String name;
    protected Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean useItem(Player user, Player target, Shotgun shotgun);
}

