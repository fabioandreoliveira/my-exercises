package io.codeforall.fanstatics;

public class Main {
    public static void main(String[] args) {
        Arena arena = new Arena();

        Hero mage = new Mage("Gandalf", 100, 50);
        Hero warrior = new Warrior("Conan", 100, 30);
        Hero cleric = new Cleric("Elena", 100, 35);
        Hero rogue = new Rogue("Robin", 100, 40);

        arena.addHero(mage);
        arena.addHero(warrior);
        arena.addHero(cleric);
        arena.addHero(rogue);

        arena.startBattle();
    }
}