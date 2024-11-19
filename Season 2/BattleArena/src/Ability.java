public interface Ability {

    void activate(Hero user, Hero target);

    String getName();
    int getManaCost();
    int getPower();

    int getCurrentCooldown();
    int getCooldown();
    void startCooldown();
    void reduceCooldown();
}
}
