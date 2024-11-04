package io.codeforall.fanstatics;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    protected String name;
    protected int health;
    protected int mana;
    protected List<Ability> abilities = new ArrayList<>();

    public Hero(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void useAbility(int index, Hero target) {
        if (index >= 0 && index < abilities.size()) {
            abilities.get(index).use(target);
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public void heal(int amount) {
        health += amount;
        System.out.println(name + " heals for " + amount + " points.");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}