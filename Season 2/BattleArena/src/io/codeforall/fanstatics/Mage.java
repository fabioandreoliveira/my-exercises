package io.codeforall.fanstatics.hero;

import io.codeforall.fanstatics.ability.Fireball;

public class Mage extends io.codeforall.fanstatics.hero.Hero {
    public Mage(String name){
        super("Mage", name);
        this.setAbility(new Fireball("Fireball"));
    }
}