class Player {
    private final String name;
    private final Die die;

    public Player(String name, Die die) {
        this.name = name;
        this.die = die;
    }

    public String getName() {
        return name;
    }

    public Die getDie() {
        return die;
    }
}