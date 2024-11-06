package io.codeforall.fanstatics;

import io.codeforall.fanstatics.ability.ShieldBlock;

public class Warrior extends io.codeforall.fanstatics.hero.Hero {
    public boolean shieldOn;
    public Warrior(String name){
        super("Warrior", name);
        this.setAbility(new ShieldBlock("ShieldBlock"));
        this.shieldOn = false;
    }
}